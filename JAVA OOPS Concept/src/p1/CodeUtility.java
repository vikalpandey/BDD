package p1;


import static com.rosaloves.bitlyj.Bitly.as;
import static com.rosaloves.bitlyj.Bitly.shorten;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.net.HttpURLConnection;
import java.net.InetAddress;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.nio.charset.Charset;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.testng.Reporter;
import org.testng.TestNG;
import org.testng.collections.Lists;
import org.w3c.dom.Document;
import org.w3c.dom.DocumentType;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;

import com.builds.reporting.EmailTemplate;
import com.builds.reporting.ExcelReporting;
import com.builds.reporting.Testng_Result;
import com.builds.test.salesTest.StrtoXML_AkshatTest;
import com.builds.test.smoke.AcceptanceTest;
import com.google.api.client.http.FileContent;
import com.google.api.services.drive.Drive;
import com.google.api.services.drive.model.FileList;
import com.google.gson.Gson;
import com.mysql.jdbc.Connection;
import com.relevantcodes.extentreports.ExtentReports;
import com.rosaloves.bitlyj.Url;

public class CodeUtility {

	// Check this method (of no use)
	boolean isRowEmpty(Row row) {
		try {
			for (int c = row.getFirstCellNum(); c < row.getLastCellNum(); c++) {
				Cell cell = row.getCell(c);
				if (cell != null && cell.getCellType() != Cell.CELL_TYPE_BLANK)
					return false;
			}
			return true;
		} catch (Exception e) {
			Reporter.log(e.getMessage());
			return true;
		}
	}

	// Check this method (of no use)
	Map<String, String> getTestDataFromRow(Workbook wb, Sheet sh, int tcRowId) {
		CodeUtility cu = new CodeUtility();
		Map<String, String> testData = new HashMap<String, String>();
		int cellCount = 0;

		Row row = sh.getRow(tcRowId);
		Cell cell = null;
		String cellKey = null;
		String cellValue = null;

		Row tempRow = null;

		for (int x = tcRowId + 1; x <= tcRowId + 1; x++) {
			row = sh.getRow(x);
			tempRow = sh.getRow(x + 1);
			cellCount = row.getLastCellNum();
			for (int y = 0; y < cellCount; y++) {
				boolean isRowEmpty = cu.isRowEmpty(row);
				if (isRowEmpty == false) {
					cell = row.getCell(y);
					cell.setCellType(CellType.STRING);
					cellKey = cell.getStringCellValue();

					cellKey = cellKey.trim();

					cell = tempRow.getCell(y);
					cell.setCellType(CellType.STRING);
					cellValue = cell.getStringCellValue();

					cellValue = cellValue.trim();

					if (cellValue == null) {
						cellValue = "defaults";
					}
					testData.put(cellKey, cellValue);
				} else {
				}
			}
		}
		return testData;
	}

	// Check this method (of no use) modified by ravi kumar pal
	Map<String, String> getTestDataFromRow(Workbook wb, Sheet sh, int tcRowId, int count) {
		CodeUtility cu = new CodeUtility();
		Map<String, String> testData = new HashMap<String, String>();
		int cellCount = 0;

		Row row = sh.getRow(tcRowId);
		Cell cell = null;
		String cellKey = null;
		String cellValue = null;

		Row tempRow = null;

		for (int x = tcRowId + 1; x <= tcRowId + 1; x++) {
			row = sh.getRow(x);
			tempRow = sh.getRow(x + count);
			cellCount = row.getLastCellNum();
			for (int y = 0; y < cellCount; y++) {
				boolean isRowEmpty = cu.isRowEmpty(row);
				if (isRowEmpty == false) {
					cell = row.getCell(y, Row.CREATE_NULL_AS_BLANK);
					cell.setCellType(cell.CELL_TYPE_STRING);
					cellKey = cell.getStringCellValue();

					cellKey = cellKey.trim();

					cell = tempRow.getCell(y, Row.CREATE_NULL_AS_BLANK);
					cell.setCellType(cell.CELL_TYPE_STRING);
					cellValue = cell.getStringCellValue();

					cellValue = cellValue.trim();

					if (cellValue == null) {
						cellValue = "defaults";
					}
					testData.put(cellKey, cellValue);
				} else {
				}
			}
		}
		return testData;
	}

	/*
	 * This method returns the current date value
	 */
	String currentDate() {
		DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
		Date date = new Date();
		String currentDate = dateFormat.format(date);
		return currentDate;
	}

	/*
	 * This test case is used to check if the provided testCaseId has been
	 * executed once for one Test Cycle. If the test case is never executed then
	 * it is executed once and the excel sheet is updated.
	 */
	boolean configurationTestCaseToExecute(String testCaseId) throws Exception {

		FranconnectUtil fc = new FranconnectUtil();
		boolean exitMethod = false;
		boolean testToRun = false;
		boolean tcExist = false;

		String folderPath = FranconnectUtil.config.get("testReportPath");

		File file1 = new File(folderPath);
		File[] file2 = file1.listFiles();

		boolean fileExist = false;
		for (File f : file2) {
			if (f.getAbsolutePath().contains("Test_Case_Status") && exitMethod == false) {
				if (f.exists()) {
					fileExist = true;
					FileInputStream fis = new FileInputStream(f);
					Workbook wb = WorkbookFactory.create(fis);
					Sheet sh = wb.getSheetAt(0);
					for (int x = 0; x < sh.getLastRowNum() + 1; x++) {
						Row r = sh.getRow(x);
						Cell cell = r.getCell(0);
						if (cell != null && cell.getStringCellValue().equalsIgnoreCase(testCaseId)) {
							exitMethod = true;
							tcExist = true;
							Cell cell2 = r.getCell(3);
							if (cell2 != null && (cell2.getStringCellValue().equalsIgnoreCase("Passed"))) {
								testToRun = false;
								break;
							} else if (cell2 != null && (cell2.getStringCellValue().equalsIgnoreCase("Failed"))) {
								fc.utobj().throwsSkipException("Test Case Id : " + testCaseId + " failed");
							} else if (cell2 != null && (cell2.getStringCellValue().equalsIgnoreCase("Skipped"))) {
								testToRun = true;
								break;
							}
						}
					}
					if (tcExist == false) {
						testToRun = true;
					}
				} else {
					testToRun = true;
				}
			}
		}
		if (fileExist == false) {
			testToRun = true;
		}

		return testToRun;
	}

	public String getJiraIdForTc_Id(String testCaseId) {
		String arr = null;
		/*
		 * try { String DB_URL = "jdbc:mysql://192.168.8.199/FCAUTOMATION";
		 * Class.forName("com.mysql.jdbc.Driver"); Connection conn = null; conn
		 * = (Connection) DriverManager.getConnection(DB_URL, "root", "root");
		 * PreparedStatement stmtp = conn.prepareStatement(
		 * "select distinct(group_concat(JIRA_ID)) as JIRA_ID from JIRA_DATA where TC_ID IN(?)"
		 * );
		 * 
		 * stmtp.setString(1, testCaseId); ResultSet rs = stmtp.executeQuery();
		 * while (rs.next()) { arr = rs.getString("JIRA_ID"); } stmtp.close();
		 * conn.close();
		 * 
		 * } catch (Exception ex) { System.out.println(ex.getMessage()); }
		 */
		return arr;
	}

	/*
	 * Harish Dwivedi This method is used to send Email with send grid acoount .
	 */
	public void sendEmailwithsendGrid(String mailSubject, String mailBody, String mailTo, String mailCC, String mailBCC,
			String mailFrom, String replyTo, String fileName) throws Exception {

		// boolean emailSend = true;

		Properties props = new Properties();

		props.put("mail.transport.protocol", "smtp");
		props.put("mail.smtp.host", "smtp.sendgrid.net");
		props.put("mail.smtp.port", 587);
		props.put("mail.smtp.auth", "true");
		props.put("mail.debug", "false");

		Authenticator auth = new SMTPAuthenticator();
		Session session = Session.getDefaultInstance(props, auth);

		Message message = new MimeMessage(session);

		try {
			message.setFrom(new InternetAddress(mailFrom));

			try {
				message.setReplyTo(new InternetAddress[] { new InternetAddress(replyTo) });
			} catch (Exception e) {
				Reporter.log(e.getMessage());
			}

			if (mailTo != null && mailTo.length() > 0) {
				if (mailTo.contains(",")) {
					String[] email = mailTo.split(",");

					InternetAddress[] toAddresses = new InternetAddress[email.length];

					int counter = 0;
					for (String recipient : email) {
						toAddresses[counter] = new InternetAddress(recipient.trim());
						counter++;
					}
					message.setRecipients(Message.RecipientType.TO, toAddresses);
				} else {
					InternetAddress[] toAddresses = { new InternetAddress(mailTo) };
					message.setRecipients(Message.RecipientType.TO, toAddresses);
				}
			}

			if (mailCC != null && mailCC.length() > 0) {
				if (mailCC.contains(",")) {
					String[] emailcc = mailCC.split(",");

					InternetAddress[] ccAddresses = new InternetAddress[emailcc.length];

					int counter = 0;
					for (String recipient : emailcc) {
						ccAddresses[counter] = new InternetAddress(recipient.trim());
						counter++;
					}
					message.setRecipients(Message.RecipientType.CC, ccAddresses);
				} else {
					InternetAddress[] toAddresses = { new InternetAddress(mailCC) };
					message.setRecipients(Message.RecipientType.CC, toAddresses);
				}
			}

			if (mailBCC != null && mailBCC.length() > 0) {
				if (mailBCC != null && mailBCC.contains(",")) {
					String[] emailBcc = mailBCC.split(",");

					InternetAddress[] bccAddresses = new InternetAddress[emailBcc.length];

					int counter = 0;
					for (String recipient : emailBcc) {
						bccAddresses[counter] = new InternetAddress(recipient.trim());
						counter++;
					}
					message.setRecipients(Message.RecipientType.BCC, bccAddresses);
				} else {
					InternetAddress[] toAddresses = { new InternetAddress(mailBCC) };
					message.setRecipients(Message.RecipientType.BCC, toAddresses);
				}
			}
			message.setSubject(mailSubject);

			if (mailBody == null) {
				mailBody = "";
			}

			// creates message part
			MimeBodyPart messageBodyPart = new MimeBodyPart();
			messageBodyPart.setContent(mailBody, "text/html");

			// creates multi-part
			Multipart multipart = new MimeMultipart();
			multipart.addBodyPart(messageBodyPart);

			// Adding Attachment

			String[] files = null;
			if (fileName != null && fileName.length() > 0 && fileName.contains(",")) {
				files = fileName.split(",");
			}

			if (files != null && files.length > 1) {
				MimeBodyPart attachPart = null;
				for (String f : files) {
					File file = new File(f);
					if (file.exists()) {
						attachPart = new MimeBodyPart();
						fileName = file.getAbsolutePath();
						attachPart.attachFile(fileName);
						multipart.addBodyPart(attachPart);
					}
				}
			} else {
				if (fileName != null && fileName.length() > 0) {
					File file = new File(fileName);
					fileName = null;

					MimeBodyPart attachPart = new MimeBodyPart();
					if (file.exists() == true) {
						fileName = file.getAbsolutePath();
						attachPart.attachFile(fileName);
						multipart.addBodyPart(attachPart);
					}
				}
			}

			try {
				message.setContent(multipart);
				Transport.send(message);
			} catch (Exception e) {
				Reporter.log(e.getMessage());
			}
		} catch (Exception e2) {
			Reporter.log(e2.toString());
			e2.printStackTrace();
		}

	}

	private class SMTPAuthenticator extends javax.mail.Authenticator {
		public PasswordAuthentication getPasswordAuthentication() {
			String username = "clienttest4";
			String password = "ki4arotuny";
			return new PasswordAuthentication(username, password);
		}
	}

	public String makeShortUrl(String longUrl) {
		String ul = null;
		try {
			Url url = as("ravikumarpal", "R_0e04f5c624ed4e12b48ddd8e79a7e8c6").call(shorten(longUrl));
			ul = url.getShortUrl();
			System.out.println("art bitfly:" + ul);
		} catch (Exception e) {
			Reporter.log(e.getMessage().toString());
			Reporter.log("Using Google Short Api");
			ul = makeShortUrl_old(longUrl);
		}

		if (ul == null) {
			return longUrl;
		} else {
			return ul;
		}
	}

	public String makeShortUrl_old(String longUrl) {

		String GOOGLE_URL_SHORT_API = "https://www.googleapis.com/urlshortener/v1/url";
		String GOOGLE_API_KEY = /* "<google-app-api-key>" */"AIzaSyCEY_a_gz9EeBXWIESpC4nBSYarOJ8KhnE";

		if (longUrl == null) {
			return longUrl;
		} else if (!longUrl.startsWith("http://") && !longUrl.startsWith("https://")) {

			longUrl = "http://" + longUrl;
		}
		try {
			String json = "{\"longUrl\": \"" + longUrl + "\"}";
			String apiURL = GOOGLE_URL_SHORT_API + "?key=" + GOOGLE_API_KEY;

			HttpPost postRequest = new HttpPost(apiURL);
			postRequest.setHeader("Content-Type", "application/json");
			postRequest.setEntity(new StringEntity(json, "UTF-8"));

			CloseableHttpClient httpClient = HttpClients.createDefault();
			HttpResponse response = httpClient.execute(postRequest);
			String responseText = EntityUtils.toString(response.getEntity());

			Gson gson = new Gson();
			@SuppressWarnings("unchecked")
			HashMap<String, String> res = gson.fromJson(responseText, HashMap.class);

			return res.get("id");

		} catch (MalformedURLException e) {
			Reporter.log(e.getMessage());
			return "error";
		} catch (IOException e) {
			Reporter.log(e.getMessage());
			return "error";
		}

	}

	/*
	 * Used to get the Local Host IP for reporting purpose.
	 */
	public String getLocalHostIP() throws Exception {
		InetAddress IP = InetAddress.getLocalHost();
		String systemIp = IP.getHostAddress();
		if (systemIp != null && systemIp.length() > 0) {
			systemIp = systemIp.trim();
		} else {
			systemIp = "ip-not-available";
		}
		return systemIp;
	}

	public com.google.api.services.drive.model.File createBaseFolder(Drive service, String folderName,
			GoogleDrive qStart) throws IOException {

		List<com.google.api.services.drive.model.File> result = new ArrayList<com.google.api.services.drive.model.File>();
		com.google.api.services.drive.model.File file = null;

		try {

			FileList files = service.files().list()
					.setQ(" 'root' in parents and mimeType = 'application/vnd.google-apps.folder'and trashed = false")
					.execute();
			result.addAll(files.getFiles());

			if (result.isEmpty() == true) {

				com.google.api.services.drive.model.File fileMetadata = new com.google.api.services.drive.model.File();
				fileMetadata.setName(folderName);
				fileMetadata.setMimeType("application/vnd.google-apps.folder");
				file = service.files().create(fileMetadata).setFields("id , name").execute();
				qStart.permission(service, file.getId());

			} else {

				boolean isBaseFolderExist = false;

				for (int i = 0; i < result.size(); i++) {

					if (result.get(i).containsValue(folderName)) {
						isBaseFolderExist = true;
						file = result.get(i);
						// break;
					}
				}

				if (isBaseFolderExist == false) {
					com.google.api.services.drive.model.File fileMetadata = new com.google.api.services.drive.model.File();
					fileMetadata.setName(folderName);
					fileMetadata.setMimeType("application/vnd.google-apps.folder");
					file = service.files().create(fileMetadata).setFields("id , name").execute();
					qStart.permission(service, file.getId());
				}

			}

		} catch (Exception e) {
			Reporter.log(e.getMessage());
			// System.out.println(e.getMessage());
		}

		return file;
	}

	// Create Child Folder In Google Drive
	private com.google.api.services.drive.model.File createChidFolder(Drive service, String childFolderName,
			GoogleDrive qStart, com.google.api.services.drive.model.File file) throws IOException {

		List<com.google.api.services.drive.model.File> result = new ArrayList<com.google.api.services.drive.model.File>();
		com.google.api.services.drive.model.File file1 = null;

		try {

			FileList files = service.files().list()
					.setQ(" '" + file.getId()
							+ "' in parents and mimeType = 'application/vnd.google-apps.folder'and trashed = false")
					.execute();
			result.addAll(files.getFiles());

			if (result.isEmpty() == true) {
				com.google.api.services.drive.model.File fileMetadata = new com.google.api.services.drive.model.File();
				fileMetadata.setName(childFolderName);
				fileMetadata.setMimeType("application/vnd.google-apps.folder");
				fileMetadata.setParents(Collections.singletonList(file.getId()));
				file1 = service.files().create(fileMetadata).setFields("id , name").execute();
				qStart.permission(service, file1.getId());
			} else {

				boolean isFolderExist = false;

				for (int i = 0; i < result.size(); i++) {

					if (result.get(i).containsValue(childFolderName)) {

						isFolderExist = true;
						file1 = result.get(i);
					}
				}

				if (isFolderExist == false) {
					com.google.api.services.drive.model.File fileMetadata = new com.google.api.services.drive.model.File();
					fileMetadata.setName(childFolderName);
					fileMetadata.setMimeType("application/vnd.google-apps.folder");
					fileMetadata.setParents(Collections.singletonList(file.getId()));
					file1 = service.files().create(fileMetadata).setFields("id , name").execute();
					qStart.permission(service, file1.getId());
				}
			}

		} catch (Exception e) {
			Reporter.log(e.getMessage());
		}

		return file1;
	}

	public void runTestScriptFromXML() throws Exception {
		BaseUtil util = new BaseUtil();
		try {

			// Create a baseDirFolder
			File file = new File(FranconnectUtil.config.get("outputDirectory"));
			if (file.exists() == false) {
				file.mkdirs();
			}
			FranconnectUtil.config.put("baseDirFolder", file.getAbsolutePath());

			String googleDriveBaseDir = "Selenium_Test_Output";
			FranconnectUtil.config.put("googleDriveBaseDir", googleDriveBaseDir);

			// Create current date format
			DateFormat dateFormat = new SimpleDateFormat("yyyy_MM_dd.HH_mm_ss");
			Date date = new Date();
			String timeStamp = dateFormat.format(date);

			// Create current date folder
			String currentDate = timeStamp.substring(0, timeStamp.lastIndexOf("."));
			String currentDateFolderPath = FranconnectUtil.config.get("outputDirectory").concat("//")
					.concat(currentDate);
			FranconnectUtil.config.put("currentDateFolderPath", createFolder(currentDateFolderPath));

			// Setting up the date Folder in google

			String googleDriveCurrentDateFolder = currentDate;
			FranconnectUtil.config.put("googleDriveCurrentDateFolder", googleDriveCurrentDateFolder);

			// Create current IP Folder

			String ipAddress = "";

			if (FranconnectUtil.config.get("jspHit").equalsIgnoreCase("No")) {
				ipAddress = getLocalHostIP();
			} else if (FranconnectUtil.config.get("jspHit").equalsIgnoreCase("Yes")) {
				ipAddress = FranconnectUtil.config.get("IPADDRESS");
			} else {
				ipAddress = "Not Found";
			}
			String ipFolderPath = FranconnectUtil.config.get("currentDateFolderPath").concat("//").concat(ipAddress);
			FranconnectUtil.config.put("ipFolderPath", createFolder(ipFolderPath));
			FranconnectUtil.config.put("ipAddress", ipAddress);

			String googleDriveIPFolder = ipAddress;
			FranconnectUtil.config.put("googleDriveIPFolder", googleDriveIPFolder);

			// Create current time Folder (including random number)
			String currentTime = timeStamp.substring(timeStamp.lastIndexOf(".") + 1, timeStamp.length());
			currentTime = currentTime.concat("_").concat(util.generateRandomNumber6Digit());
			String currentTimeFolderPath = ipFolderPath.concat("//").concat(currentTime);
			FranconnectUtil.config.put("currentTimeFolderPath", createFolder(currentTimeFolderPath));

			String googleDriveTimeStampFolder = currentTime;
			FranconnectUtil.config.put("googleDriveTimeStampFolder", googleDriveTimeStampFolder);

			// Create Test Data Folder & Copy the input folder data to output
			// folder data
			String testDataFolderPath = FranconnectUtil.config.get("currentTimeFolderPath").concat("//")
					.concat("TestData");
			FranconnectUtil.config.put("testDataFolderPath", createFolder(testDataFolderPath));

			File srcTestData = new File(FranconnectUtil.config.get("inputDirectory").concat("/").concat("testData"));
			File dstTestData = new File(FranconnectUtil.config.get("testDataFolderPath"));
			FileUtils.copyDirectory(srcTestData, dstTestData);

			// Create user folder for existing user check

			String userFolderPath = currentTimeFolderPath.concat("//").concat("users");
			FranconnectUtil.config.put("userFolderPath", createFolder(userFolderPath));

			GoogleDrive qStart = new GoogleDrive();
			com.google.api.services.drive.model.File filea = createBaseFolder(qStart.getDriveService(),
					googleDriveBaseDir, qStart);
			com.google.api.services.drive.model.File fileb = createChidFolder(qStart.getDriveService(),
					FranconnectUtil.config.get("googleDriveCurrentDateFolder"), qStart, filea);
			com.google.api.services.drive.model.File filec = createChidFolder(qStart.getDriveService(),
					FranconnectUtil.config.get("googleDriveIPFolder"), qStart, fileb);
			com.google.api.services.drive.model.File filed = createChidFolder(qStart.getDriveService(),
					FranconnectUtil.config.get("googleDriveTimeStampFolder"), qStart, filec);

			String[] moduleList = null;

			if (FranconnectUtil.config.get("moduleList").contains(",")) {
				moduleList = FranconnectUtil.config.get("moduleList").trim().split(",");
			} else {
				moduleList = new String[1];
				moduleList[0] = FranconnectUtil.config.get("moduleList");
			}

			// Send Start Confirmation email

			/*
			 * String timeStampURL = "https://drive.google.com/open?id=" +
			 * filed.getId(); String timeStampShortURL =
			 * makeShortUrl(timeStampURL);
			 */

			/*
			 * Test Build confirmation mail
			 */

			// sendPriorToTestEmail(timeStampShortURL);

			for (String module : moduleList) {

				/**
				 * Change By Inzamam : 04/Sep/2018 Check if module name is blank
				 */
				if (module.length() > 0) {
					// reports=new
					// ExtentReports("D:\\Tutorials\\SeleniumPractice\\Reports\\"+FranconnectUtil.config.get("moduleList")+"_results.html",true);
					FranconnectUtil.executingModule = module.trim();
					String modulePath = FranconnectUtil.config.get("currentTimeFolderPath").concat("//")
							.concat(module.trim());
					FranconnectUtil.config.put("modulePath", createFolder(modulePath));
					com.google.api.services.drive.model.File filee = createChidFolder(qStart.getDriveService(),
							module.trim(), qStart, filed);

					String testReportPath = FranconnectUtil.config.get("modulePath").concat("//").concat("reports");
					FranconnectUtil.config.put("testReportPath", createFolder(testReportPath));

					BaseUtil.reports = new ExtentReports(
							FranconnectUtil.config.get("testReportPath") + "\\ExtentReport.html");

					FranconnectUtil.config.put("googleDriveTestReportFolder", "TestReport");

					com.google.api.services.drive.model.File filef = createChidFolder(qStart.getDriveService(),
							FranconnectUtil.config.get("googleDriveTestReportFolder"), qStart, filee);

					String testLogFolderPath = FranconnectUtil.config.get("modulePath").concat("//").concat("logs");
					FranconnectUtil.config.put("testLogFolderPath", createFolder(testLogFolderPath));

					String screenShotPath = FranconnectUtil.config.get("modulePath").concat("//").concat("screenshot");
					FranconnectUtil.config.put("screenShotPath", createFolder(screenShotPath));

					FranconnectUtil.config.put("googleDriveScreenShotFolder", "ScreenShot");

					com.google.api.services.drive.model.File fileg = createChidFolder(qStart.getDriveService(),
							FranconnectUtil.config.get("googleDriveScreenShotFolder"), qStart, filee);

					//Google Drive Path Put
					FranconnectUtil.config.put("dateFolderId", fileb.getId());
					FranconnectUtil.config.put("ipFolderId", filec.getId());
					FranconnectUtil.config.put("timeStampFolderId", filed.getId());
					FranconnectUtil.config.put("moduleReportPathGoogle", filee.getId());
					FranconnectUtil.config.put("screenShotFolderId", fileg.getId());
					FranconnectUtil.config.put("testReportFolderId", filef.getId());

					String longUrl = "https://drive.google.com/open?id=" + filee.getId();

					String shortUrl = makeShortUrl(longUrl);

					FranconnectUtil.config.put("moduleReportPathGoogle", shortUrl);

					// System.out.println("Short Url : "+shortUrl);

					String customXMLFile = FranconnectUtil.config.get("inputDirectory").concat("//testXml//custom.xml");
					String currentModuleXML = FranconnectUtil.config.get("modulePath");
					FileUtils.copyFileToDirectory(new File(customXMLFile), new File(currentModuleXML));
					currentModuleXML = currentModuleXML.concat("//custom.xml");
					FranconnectUtil.config.put("currentModuleXML", currentModuleXML);

					// FranconnectUtil.config =
					// createTestCaseReport(FranconnectUtil.config,module);

					UpdateParameterValueInXML(FranconnectUtil.config.get("currentModuleXML"),
							FranconnectUtil.config.get("SUITE_NAME"), FranconnectUtil.config.get("THREAD_COUNT"),
							FranconnectUtil.config.get("TEST_NAME"), module.trim());

					runTest(FranconnectUtil.config.get("currentModuleXML"));

					String xlsReport = FranconnectUtil.config.get("modulePath").concat("//reports//") + module.trim()
							+ ".xls";
					generateReport(module,
							FranconnectUtil.config.get("modulePath").concat("//reports//testng-results.xml"),
							xlsReport);

					ModuleReport email = new ModuleReport();

					email = reportAnalysis(module.trim(), xlsReport, email);
					email.setBrowserName(FranconnectUtil.config.get("browserName"));
					email.setModule(module.trim());
					email.setGoogleTestDire(shortUrl);

					sendEmail(module.trim(), xlsReport, email);

					// Upload Report file in google drive
					uploadFileUploadDrive(qStart.getDriveService(), module.trim() + ".xls",
							FranconnectUtil.config.get("testReportFolderId"),
							FranconnectUtil.config.get("modulePath").concat("//").concat("reports"),
							"application/vnd.ms-excel");
					try {
						BaseUtil.reports.flush();
						BaseUtil.reports.close();
					} catch (Exception e) {
						System.out.println(e.getMessage());
					}
				}
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	private ModuleReport reportAnalysis(String module, String xlsReport, ModuleReport email)
			throws MalformedURLException, IOException {

		String BuildVersion = "";
		String totalNumberOfTC = "";
		String testCasesPassed = "";
		String testCasesFailed = "";
		String testCasesSkipped = "";
		String totalTimeTaken = "";
		String systemIP = "";
		String failPercentage = "";
		String googleTestDire = "";
		String buildUrl = "";

		String messageBody = "";

		try {
			if (xlsReport != null && xlsReport.length() > 1) {
				FileInputStream fis = new FileInputStream(xlsReport);
				Workbook wb = WorkbookFactory.create(fis);

				Sheet sh = wb.getSheetAt(0);

				Row row0 = sh.getRow(0);
				Cell cellSystemIP = row0.getCell(3);
				systemIP = cellSystemIP.getStringCellValue();

				email.setIPADDRESS(systemIP);

				Row row1 = sh.getRow(1);
				Cell celltotalTimeTaken = row1.getCell(3);
				totalTimeTaken = celltotalTimeTaken.getStringCellValue();

				email.setTotalTimeTaken(totalTimeTaken);

				Row row = sh.getRow(4);
				Cell cell = row.getCell(1);
				BuildVersion = cell.getStringCellValue();

				email.setBuildVersion(BuildVersion);

				Row row2 = sh.getRow(2);
				Cell celltotal = row2.getCell(3);
				totalNumberOfTC = celltotal.getStringCellValue();

				email.setTotalNumberOfTC(totalNumberOfTC);

				Row row3 = sh.getRow(3);
				Cell cellpassed = row3.getCell(3);
				testCasesPassed = cellpassed.getStringCellValue();

				email.setTestCasesPassed(testCasesPassed);

				Row row4 = sh.getRow(4);
				Cell cellfailed = row4.getCell(3);
				testCasesFailed = cellfailed.getStringCellValue();

				testCasesFailed = testCasesFailed.trim();
				email.setTestCasesFailed(testCasesFailed);

				Row row5 = sh.getRow(5);
				Cell cellSkipped = row5.getCell(3);
				testCasesSkipped = cellSkipped.getStringCellValue();

				email.setTestCasesSkipped(testCasesSkipped);

				wb.close();

				String messageSubject = FranconnectUtil.config.get("MAIL_SUBJECT")
						.concat(" - " + BuildVersion + " : " + module);

				if (module != null && module.length() > 1) {
					module = StringUtils.capitalize(module);
				}

				buildUrl = FranconnectUtil.config.get("buildUrl");

				email.setBuildUrl(buildUrl);

				String browserName = FranconnectUtil.config.get("browserName");
				if (browserName != null && browserName.length() > 1) {
					browserName = StringUtils.capitalize(browserName);
				}
				String os = getOSInfo();

				email.setOs(os);

				googleTestDire = FranconnectUtil.config.get("moduleReportPathGoogle");

				String requestIP = FranconnectUtil.config.get("IPADDRESS");
				if (requestIP != null && requestIP.length() > 0) {
					//
				} else {
					requestIP = systemIP;
				}

				email.setRequestIP(requestIP);

				String header = null;

				try {
					int totalTCCount = Integer.parseInt(totalNumberOfTC);
					int passedTCCount = Integer.parseInt(testCasesPassed);

					if (totalTCCount > 0 && (totalTCCount - passedTCCount) == 0) {
						header = "-All PASS";
					}
				} catch (Exception e) {
					Reporter.log(e.getMessage());
					header = null;
				}

				double failedCalculated = 0;
				try {
					double totalTCCount = Double.parseDouble(totalNumberOfTC);
					double failedTCCount = Double.parseDouble(testCasesFailed);
					if (totalTCCount >= 0 && (failedTCCount >= 0)) {
						failedCalculated = (failedTCCount / totalTCCount) * 100;
					}

					failPercentage = String.valueOf(failedCalculated);

					if (failPercentage.contains(".")) {
						if (failPercentage.length() > 5) {
							failPercentage = failPercentage.substring(0, 5);
						}
					}
				} catch (Exception e) {
					Reporter.log(e.getMessage());
				}

				if (header != null) {
					messageSubject = messageSubject.concat(header);
				}

				email.setFailPercentage(failPercentage);

				EmailTemplate ET = new EmailTemplate();
				messageBody = ET.readEmailFormat();

				messageBody = messageBody.replace("$buildUrl$", buildUrl);
				messageBody = messageBody.replace("$os$", os);
				messageBody = messageBody.replace("$browserName$", browserName);
				messageBody = messageBody.replace("$moduleName$", module);
				messageBody = messageBody.replace("$tagNo$", BuildVersion);
				messageBody = messageBody.replace("$tcCount$", totalNumberOfTC);
				messageBody = messageBody.replace("$tcPassed$", testCasesPassed);
				messageBody = messageBody.replace("$tcFailed$", testCasesFailed);
				messageBody = messageBody.replace("$tcSkipped$", testCasesSkipped);
				messageBody = messageBody.replace("$failPercentage$", failPercentage);
				messageBody = messageBody.replace("$timeTaken$", totalTimeTaken);
				messageBody = messageBody.replace("$ipAddress$", FranconnectUtil.config.get("IPADDRESS"));
				messageBody = messageBody.replace("$tcReportUrl$", googleTestDire);
				messageBody = messageBody.replace("$requestFromIP$", requestIP);

			}

		} catch (Exception e2) {
			e2.printStackTrace();
			System.out.println(e2.getMessage());
			Reporter.log(e2.toString());
		}

		String messageSubject = FranconnectUtil.config.get("MAIL_SUBJECT")
				.concat(" - " + BuildVersion + " : " + module);

		//
		email.setMailSubject(messageSubject);
		email.setMailBody(messageBody);

		return email;

	}

	/*
	 * This method is to send the email report
	 */
	private void sendEmail(String module, String xlsReport, ModuleReport email) throws Exception {

		System.out.println(">>>>>>>>>>>>>>>>> Sending Email >>>>>>>>>>>>>>> ");

		Properties props = new Properties();

		props.put("mail.transport.protocol", "smtp");
		props.put("mail.smtp.host", "smtp.sendgrid.net");
		props.put("mail.smtp.port", 587);
		props.put("mail.smtp.auth", "true");
		props.put("mail.debug", "false");

		Authenticator auth = new SMTPAuthenticator();
		//Session session = Session.getDefaultInstance(props, auth);
		
		SecurityManager security = System.getSecurityManager();
		System.out.println("############Security Manager : " + security);
		
		Session session = Session.getInstance(props, auth);
		
		security = System.getSecurityManager();
		System.out.println("############Security Manager : " + security);

		System.out.println("---------------------------Session Created");
		
		Message message = new MimeMessage(session);

		message.setSubject(email.getMailSubject());
		
		
		System.out.println("---------------------------Subject name Set");
		

		try {
			message.setFrom(new InternetAddress(FranconnectUtil.config.get("SMTP_FROM_ADDRESS")));

			try {
				message.setReplyTo(
						new InternetAddress[] { new InternetAddress(FranconnectUtil.config.get("SMTP_REPLY_TO")) });
			} catch (Exception e) {
				Reporter.log(e.getMessage());
				System.out.println(e.getMessage());
			}
			
			System.out.println("Set Reply To");
			
			if (FranconnectUtil.config.get("emailIds") != null
					&& FranconnectUtil.config.get("emailIds").contains(",")) {
				String[] emailTo = FranconnectUtil.config.get("emailIds").split(",");

				InternetAddress[] toAddresses = new InternetAddress[emailTo.length];

				int counter = 0;
				for (String recipient : emailTo) {
					toAddresses[counter] = new InternetAddress(recipient.trim());
					counter++;
				}
				message.setRecipients(Message.RecipientType.TO, toAddresses);
			} else {
				InternetAddress[] toAddresses = { new InternetAddress(FranconnectUtil.config.get("emailIds")) };
				message.setRecipients(Message.RecipientType.TO, toAddresses);
			}
			
			System.out.println("To Address Set");

			try {
				if (FranconnectUtil.config.get("SMTP_CC_ADDRESS") != null
						&& FranconnectUtil.config.get("SMTP_CC_ADDRESS").contains(",")) {
					String[] emailcc = FranconnectUtil.config.get("SMTP_CC_ADDRESS").split(",");

					InternetAddress[] ccAddresses = new InternetAddress[emailcc.length];

					int counter = 0;
					for (String recipient : emailcc) {
						ccAddresses[counter] = new InternetAddress(recipient.trim());
						counter++;
					}
					message.setRecipients(Message.RecipientType.CC, ccAddresses);
				} else {
					InternetAddress[] toAddresses = {
							new InternetAddress(FranconnectUtil.config.get("SMTP_CC_ADDRESS")) };
					message.setRecipients(Message.RecipientType.CC, toAddresses);
				}
			} catch (Exception e) {
				Reporter.log(e.getMessage());
				System.out.println(e.getMessage());
			}
			
			System.out.println("CC Address Set");

			try {
				if (FranconnectUtil.config.get("SMTP_BCC_ADDRESS") != null
						&& FranconnectUtil.config.get("SMTP_BCC_ADDRESS").contains(",")) {
					String[] emailcc = FranconnectUtil.config.get("SMTP_BCC_ADDRESS").split(",");

					InternetAddress[] ccAddresses = new InternetAddress[emailcc.length];

					int counter = 0;
					for (String recipient : emailcc) {
						ccAddresses[counter] = new InternetAddress(recipient.trim());
						counter++;
					}
					message.setRecipients(Message.RecipientType.BCC, ccAddresses);
				} else {
					InternetAddress[] toAddresses = {
							new InternetAddress(FranconnectUtil.config.get("SMTP_BCC_ADDRESS")) };
					message.setRecipients(Message.RecipientType.BCC, toAddresses);
				}
			} catch (Exception e) {
				Reporter.log(e.getMessage());
				System.out.println(e.getMessage());
			}
			
			System.out.println("BCC Address Set");
			

			if (module != null && module.length() > 1) {
				module = StringUtils.capitalize(module);
			}
			
			System.out.println("Module Name Capitalized");
			

			message.setSentDate(new Date());

			String browserName = FranconnectUtil.config.get("browserName");
			if (browserName != null && browserName.length() > 1) {
				browserName = StringUtils.capitalize(browserName);
			}
			String os = getOSInfo();

			System.out.println("OS Name set");
			
			EmailTemplate ET = new EmailTemplate();
			String messageBody = ET.readEmailFormat();

			messageBody = messageBody.replace("$buildUrl$", email.getBuildUrl());
			messageBody = messageBody.replace("$os$", email.getOs());
			messageBody = messageBody.replace("$browserName$", email.getBrowserName());
			messageBody = messageBody.replace("$moduleName$", email.getModule());
			messageBody = messageBody.replace("$tagNo$", email.getBuildVersion());
			messageBody = messageBody.replace("$tcCount$", email.getTotalNumberOfTC());
			messageBody = messageBody.replace("$tcPassed$", email.getTestCasesPassed());
			messageBody = messageBody.replace("$tcFailed$", email.getTestCasesFailed());
			messageBody = messageBody.replace("$tcSkipped$", email.getTestCasesSkipped());
			messageBody = messageBody.replace("$failPercentage$", email.getFailPercentage());
			messageBody = messageBody.replace("$timeTaken$", email.getTotalTimeTaken());
			messageBody = messageBody.replace("$ipAddress$", email.getIPADDRESS());
			messageBody = messageBody.replace("$tcReportUrl$", email.getGoogleTestDire());
			messageBody = messageBody.replace("$requestFromIP$", email.getRequestIP());

			
			System.out.println("Message Body Set" + messageBody);
			
			
			// String messageContent =
			// buildUrl.concat(browserName).concat(module).concat(os).concat(BuildVersion).concat(totalNumberOfTC).concat(testCasesPassed).concat(testCasesFailed).concat(testCasesSkipped).concat(totalTimeTaken).concat(systemIP).concat(googleTestDire).concat(requestIP);

			// creates message part
			MimeBodyPart messageBodyPart = new MimeBodyPart();
			messageBodyPart.setContent(messageBody, "text/html");
			
			System.out.println("Message Body Set Content");
			
			// creates multi-part
			Multipart multipart = new MimeMultipart();
			multipart.addBodyPart(messageBodyPart);

			System.out.println("Message Body Add Body Part");
			
			MimeBodyPart attachPart = new MimeBodyPart();
			MimeBodyPart attachPart_js = new MimeBodyPart();

			try {
				multipart.addBodyPart(attachPart);
			} catch (Exception e) {
				Reporter.log(e.getMessage());
				System.out.println(e.getMessage());
			}

			System.out.println("multipart add body part");
			
			File reportFile = new File(xlsReport);
			if (xlsReport != null && reportFile.exists()) {
				System.out.println(xlsReport);
				attachPart.attachFile(xlsReport);
			}

			System.out.println("xls report path set.   "+reportFile);
			
			try {
				message.setContent(multipart);

				Transport.send(message);
			} catch (Exception e) {
				Reporter.log(e.getMessage());
				System.out.println(e.getMessage());
			}
			
			System.out.println("Email Sent.");
			
		} catch (Exception e2) {
			e2.printStackTrace();
			System.out.println(e2.getMessage());
			Reporter.log(e2.toString());
			
			
		}

		/*
		 * Ryver post
		 */

		System.out.println("Printing in Logs");

		if (module.equalsIgnoreCase("BuildAcceptanceTest")
				&& FranconnectUtil.config.get("inserttoDB").equalsIgnoreCase("Yes")) {
			
			
			System.out.println("##############################################");
			System.out.println(AcceptanceTest.BATRemarks);
			
			Ryver r = new Ryver();
			

			
			String header = "";
			
			int f = 0;
			try
			{
				f = Integer.parseInt(email.getTestCasesFailed());
			}catch(Exception e)
			{
				
			}
			
			try
			{
				f = f + Integer.parseInt(email.getTestCasesSkipped());
			}catch(Exception e)
			{
				
			}
			
			if(f>0)
			{
				header = "**Failed Test Cases**";
			}
			

			if (Integer.parseInt(email.getTestCasesFailed()) <= 0
					&& Integer.parseInt(email.getTestCasesSkipped()) <= 0) {
				AcceptanceTest.BATRemarks = "";
			}

			// Fc Sky Product : 1123709
			String messageRyver = "## Build Acceptance Test (BAT) report ## ".concat("\\n");
			
			messageRyver = messageRyver.concat("\\n")
					.concat("Total Number Of Test Cases: " + email.getTotalNumberOfTC());
			messageRyver = messageRyver.concat("\\n")
					.concat("Total Number Of Test Cases Failed: " + f);
			messageRyver = messageRyver.concat("\\n")
					.concat("Total Time Taken (in mins): " + email.getTotalTimeTaken());
			messageRyver = messageRyver.concat("\\n").concat("URL: " + email.getBuildUrl());
			messageRyver = messageRyver.concat("\\n")
					.concat("Reports and Screenshot path: " + email.getGoogleTestDire());

			if(header!=null && header!="")
			{
				messageRyver = messageRyver.concat("\\n").concat(header);
			}
			
			messageRyver = messageRyver.concat("\\n").concat(AcceptanceTest.BATRemarks);

			System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>     " + AcceptanceTest.BATRemarks);
			//new Ryver().PostOnRyverGroup(message, GroupName);

			//FC-Sky Product
			/*new Ryver().PostOnRyverForum(messageRyver, "1123709");*/
			
			//QA-Product
			r.PostOnRyverGroup(messageRyver, "1123658");
			
			
			/*String header = "";
			
			int f = 0;
			try
			{
				f = Integer.parseInt(email.getTestCasesFailed());
			}catch(Exception e)
			{
				
			}
			
			try
			{
				f = f + Integer.parseInt(email.getTestCasesSkipped());
			}catch(Exception e)
			{
				
			}
			
			if(f>0)
			{
				header = "**Failed Test Cases**";
			}
			

			if (Integer.parseInt(email.getTestCasesFailed()) <= 0
					&& Integer.parseInt(email.getTestCasesSkipped()) <= 0) {
				AcceptanceTest.BATRemarks = "";
			}

			// Fc Sky Product : 1123709
			String messageRyver = "##Build Acceptance Test (BAT) report".concat("\\n");
			messageRyver = messageRyver.concat("\\n")
					.concat("Total Number Of Test Cases: " + email.getTotalNumberOfTC());
			messageRyver = messageRyver.concat("\\n")
					.concat("Total Number Of Test Cases Failed: " + f);
			messageRyver = messageRyver.concat("\\n")
					.concat("Total Time Taken (in mins): " + email.getTotalTimeTaken());
			messageRyver = messageRyver.concat("\\n").concat("URL: " + email.getBuildUrl());
			messageRyver = messageRyver.concat("\\n")
					.concat("Reports and Screenshot path: " + email.getGoogleTestDire());
			messageRyver = messageRyver.concat("\\n").concat(AcceptanceTest.BATRemarks);

			if(header!=null && header!="")
			{
				messageRyver = messageRyver.concat("\\n").concat(header);
			}
			
			System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>     " + AcceptanceTest.BATRemarks);
			new Ryver().PostOnRyverForum(messageRyver, "1123709");
			//new Ryver().PostOnRyverGroup(message, GroupName);
*/
		}

	}

	// Google Drive Upload file

	public com.google.api.services.drive.model.File uploadFileUploadDrive(Drive service, String localFileName,
			String driveFolderId, String localFolderPath, String fileType) throws IOException {
		com.google.api.services.drive.model.File file = null;

		try {

			GoogleDrive qstart = new GoogleDrive();
			com.google.api.services.drive.model.File fileMetadata = new com.google.api.services.drive.model.File();
			fileMetadata.setName(localFileName);
			fileMetadata.setParents(Collections.singletonList(driveFolderId));
			String absFilePath1 = localFolderPath + "/" + localFileName;

			java.io.File filePath = new java.io.File(absFilePath1);
			FileContent mediaContent = new FileContent(/* "image/jpeg" */fileType, filePath);
			file = service.files().create(fileMetadata, mediaContent).setFields("id, parents,webViewLink").execute();
			qstart.permission(service, file.getId());

		} catch (Exception e) {
			Reporter.log(e.getMessage());
			// System.out.println(e);
		}
		return file;
	}

	/*
	 * This method is used to update the testng xml file after each module is
	 * executed.
	 */

	private void UpdateParameterValueInXML(String fileName, String suiteName, String threadCount, String testName,
			String module) throws Exception {
		System.out.println(">>>>>>>>>>>>>>>>> Inside : UpdateParameterValueInXML");

		try {
			File f = new File(fileName);

			if (f.exists() == true) {

				DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
				DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
				Document doc = docBuilder.parse(f.getAbsolutePath());

				NodeList nodeList1 = doc.getElementsByTagName("suite");
				nodeList1.item(0).getAttributes().getNamedItem("name").setNodeValue(suiteName);
				NodeList nodeList2 = doc.getElementsByTagName("suite");
				nodeList2.item(0).getAttributes().getNamedItem("thread-count").setNodeValue(threadCount);
				NodeList nodeList3 = doc.getElementsByTagName("test");
				nodeList3.item(0).getAttributes().getNamedItem("name").setNodeValue(testName);
				NodeList nodeList4 = doc.getElementsByTagName("include");
				nodeList4.item(0).getAttributes().getNamedItem("name").setNodeValue(module);
				NodeList nodeList = doc.getElementsByTagName("test");

				DOMSource source = new DOMSource(doc);
				TransformerFactory transformerFactory = TransformerFactory.newInstance();
				Transformer transformer = transformerFactory.newTransformer();

				try {
					transformer.setOutputProperty(OutputKeys.INDENT, "yes");

					DocumentType doctype = doc.getDoctype();
					if (doctype != null) {
						transformer.setOutputProperty(OutputKeys.DOCTYPE_PUBLIC, doctype.getPublicId());
						transformer.setOutputProperty(OutputKeys.DOCTYPE_SYSTEM, doctype.getSystemId());
					}

				} catch (Exception e) {
					Reporter.log(e.getMessage());
				}
				StreamResult result = new StreamResult(f.getAbsolutePath());
				transformer.transform(source, result);
			}
		} catch (Exception e) {
			Reporter.log(e.getMessage());
			System.out.println(e.getMessage());
		}
	}

	/*
	 * This method provided the Operating System Info
	 */

	public String getOSInfo() {
		return System.getProperty("os.name");
	}

	/*
	 * Retrieve the Build Version so that it can be used in reporting
	 */

	public String getBuildVersion(String myURL) {
		String versionName = buildVersionCheck(myURL);
		if (versionName.contains("Page moved permanetly")
				|| versionName.contains("You will shortly be redirected to an apprioriate page.")
				|| versionName.contains("301 Moved Permantly")) {
			String modifiedUrl = myURL.replace("http:", "https:");
			versionName = buildVersionCheck(modifiedUrl);
		}

		return versionName;

	}

	public String buildVersionCheck(String myURL) {

		String versionName = "(Tag Not Available)";

		try {
			if (!myURL.endsWith("/")) {
				myURL = myURL.concat("/");
			}

			String version = "version.txt";

			myURL = myURL.concat(version);

			try {
				StringBuilder sb = new StringBuilder();
				URLConnection urlConn = null;
				InputStreamReader in = null;
				try {
					URL url = new URL(myURL);
					urlConn = url.openConnection();
					if (urlConn != null)
						urlConn.setReadTimeout(60 * 1000);
					if (urlConn != null) {
						if (urlConn.getInputStream() != null) {
							in = new InputStreamReader(urlConn.getInputStream(), Charset.defaultCharset());
							BufferedReader bufferedReader = new BufferedReader(in);
							if (bufferedReader != null) {
								int cp;
								while ((cp = bufferedReader.read()) != -1) {
									sb.append((char) cp);
								}
								bufferedReader.close();
							}
						}
					}
					in.close();
				} catch (Exception e) {
					Reporter.log(e.getMessage());
					throw new RuntimeException("Exception while calling URL:" + myURL, e);
				}

				versionName = sb.toString();

			} catch (Exception e) {
				Reporter.log(e.getMessage());
				versionName = "(Tag Not Available)";
			}

			if (versionName != null && versionName.trim().length() > 0) {
				versionName = versionName.trim();
				try {
					if (versionName != null && versionName.length() > 0 && versionName.contains(".")) {
						try {
							versionName = versionName.replaceAll("\\.", ".");
						} catch (Exception e) {
							Reporter.log(e.getMessage());
							versionName = "(Tag Not Available)";
						}
					} else {
						versionName = "(Tag Not Available)";
					}
				} catch (Exception e) {
					Reporter.log(e.getMessage());
				}
			}
		} catch (Exception e) {
			Reporter.log(e.getMessage());
		}

		return versionName;

	}

	private String generateReport(String module, String xmlPath, String filePath) throws IOException {
		File xmlFile = new File(xmlPath);
		if (xmlFile.exists() == true) {
			ExcelReporting rpt = new ExcelReporting();
			filePath = rpt.createExcelFile(filePath);
			Testng_Result tresult = new Testng_Result();
			tresult.convertTestNgReportToXLS(module, xmlPath, filePath);
		}
		return filePath;
	}

	private String createFolder(String path) {
		File file = new File(path);

		if (file.exists() == false) {
			file.mkdir();
		}

		return file.getAbsolutePath();
	}

	private void disableSSL(String buildUrl, Map<String, String> config) throws Exception {
		MyTrustManager mtm = new MyTrustManager();
		mtm.disableSSL();
	}

	/*
	 * Used in sending the "Current Day Date current time am/pm and time zone"
	 */
	public String getCurrentDateTimeStamp() {
		Date dNow = new Date();
		SimpleDateFormat ft = new SimpleDateFormat("E dd/MM/yyyy 'at' hh:mm:ss a zzz");
		return ft.format(dNow);
	}

	public long getTimeStamp() {
		Timestamp timestamp = new Timestamp(System.currentTimeMillis());
		return timestamp.getTime();
	}

	/*
	 * This method is used to find out the build reponse code
	 */
	public int getBuildResponseCode(String buildUrl) throws Exception {
		System.setProperty("jsse.enableSNIExtension", "false");
		int code = 0;

		boolean isBuildResponseCodeFound = false;

		boolean isHttpsBuild = false;
		if (buildUrl.toLowerCase().contains("https")) {
			isHttpsBuild = true;
		}

		if (isHttpsBuild == true) {
			try {
				URL url = new URL(buildUrl);
				System.setProperty("https.proxyHost", FranconnectUtil.config.get("PROXYIP"));
				System.setProperty("https.proxyPort", FranconnectUtil.config.get("PROXYPORT"));
				HttpURLConnection connection = (HttpURLConnection) url.openConnection();
				connection.setRequestMethod("GET");
				connection.connect();
				code = connection.getResponseCode();
				isBuildResponseCodeFound = true;
			} catch (Exception e) {
				Reporter.log(e.getMessage());
				isBuildResponseCodeFound = false;
			}
		}
		if (isBuildResponseCodeFound == false && isHttpsBuild == false) {
			try {
				URL url = new URL(buildUrl);
				System.setProperty("http.proxyHost", FranconnectUtil.config.get("PROXYIP"));
				System.setProperty("http.proxyPort", FranconnectUtil.config.get("PROXYPORT"));
				HttpURLConnection connection = (HttpURLConnection) url.openConnection();
				connection.setRequestMethod("GET");
				connection.connect();
				code = connection.getResponseCode();
				System.out.println("Thread Id : " + Thread.currentThread().getId() + " Code: " + code);
				isBuildResponseCodeFound = true;
			} catch (Exception e) {
				Reporter.log(e.getMessage());
				isBuildResponseCodeFound = false;
			}
		}

		if (isBuildResponseCodeFound == false) {
			code = 0;
		}

		System.out.println("Build Response Code : " + code);
		return code;
	}

	/*
	 * This method is used to send Email.
	 */
	public void sendEmail(ModuleReport email) throws Exception {

		// boolean emailSend = true;

		Properties props = new Properties();

		props.put("mail.smtp.host", email.getSMTP_HOST_NAME());
		props.put("mail.smtp.auth", "false");
		props.put("mail.debug", "true");
		props.put("mail.smtp.port", email.getSMTP_PORT());
		props.put("mail.debug", "false");

		Session session = Session.getInstance(props);
		Message message = new MimeMessage(session);

		try {
			message.setFrom(new InternetAddress(email.getMailFrom()));

			try {
				message.setReplyTo(new InternetAddress[] { new InternetAddress(email.getReplyTo()) });
			} catch (Exception e) {
				Reporter.log(e.getMessage());
			}

			if (email.getMailTo() != null && email.getMailTo().length() > 0) {
				if (email.getMailTo().contains(",")) {
					String[] toEmail = email.getMailTo().split(",");

					InternetAddress[] toAddresses = new InternetAddress[toEmail.length];

					int counter = 0;
					for (String recipient : toEmail) {
						toAddresses[counter] = new InternetAddress(recipient.trim());
						counter++;
					}
					message.setRecipients(Message.RecipientType.TO, toAddresses);
				} else {
					InternetAddress[] toAddresses = { new InternetAddress(email.getMailTo()) };
					message.setRecipients(Message.RecipientType.TO, toAddresses);
				}
			}

			if (email.getMailCC() != null && email.getMailCC().length() > 0) {
				if (email.getMailCC().contains(",")) {
					String[] emailcc = email.getMailCC().split(",");

					InternetAddress[] ccAddresses = new InternetAddress[emailcc.length];

					int counter = 0;
					for (String recipient : emailcc) {
						ccAddresses[counter] = new InternetAddress(recipient.trim());
						counter++;
					}
					message.setRecipients(Message.RecipientType.CC, ccAddresses);
				} else {
					InternetAddress[] toAddresses = { new InternetAddress(email.getMailCC()) };
					message.setRecipients(Message.RecipientType.CC, toAddresses);
				}
			}

			if (email.getMailBCC() != null && email.getMailBCC().length() > 0) {
				if (email.getMailBCC() != null && email.getMailBCC().contains(",")) {
					String[] emailBcc = email.getMailBCC().split(",");

					InternetAddress[] bccAddresses = new InternetAddress[emailBcc.length];

					int counter = 0;
					for (String recipient : emailBcc) {
						bccAddresses[counter] = new InternetAddress(recipient.trim());
						counter++;
					}
					message.setRecipients(Message.RecipientType.BCC, bccAddresses);
				} else {
					InternetAddress[] toAddresses = { new InternetAddress(email.getMailBCC()) };
					message.setRecipients(Message.RecipientType.BCC, toAddresses);
				}
			}

			System.out.println(email.getMailSubject());

			message.setSubject(email.getMailSubject());
			message.setSentDate(new Date());
			if (email.getMailBody() == null) {
				email.setMailBody("");
			}

			// creates message part
			MimeBodyPart messageBodyPart = new MimeBodyPart();
			messageBodyPart.setContent(email.getMailBody(), "text/html");

			// creates multi-part
			Multipart multipart = new MimeMultipart();
			multipart.addBodyPart(messageBodyPart);

			// Adding Attachment

			String[] files = null;
			if (email.getAttachment() != null && email.getAttachment().length() > 0
					&& email.getAttachment().contains(",")) {
				files = email.getAttachment().split(",");
			}

			if (files != null && files.length > 1) {
				MimeBodyPart attachPart = null;
				for (String f : files) {
					File file = new File(f);
					if (file.exists()) {
						attachPart = new MimeBodyPart();
						email.setAttachment(file.getAbsolutePath());
						attachPart.attachFile(email.getAttachment());
						multipart.addBodyPart(attachPart);
					}
				}
			} else {
				if (email.getAttachment() != null && email.getAttachment().length() > 0) {
					File file = new File(email.getAttachment());
					email.setAttachment(null);

					MimeBodyPart attachPart = new MimeBodyPart();
					if (file.exists() == true) {
						email.setAttachment(file.getAbsolutePath());
						attachPart.attachFile(email.getAttachment());
						multipart.addBodyPart(attachPart);
					}
				}
			}

			try {
				message.setContent(multipart);
				Transport.send(message);
			} catch (Exception e) {
				Reporter.log(e.getMessage());
			}
		} catch (Exception e2) {
			Reporter.log(e2.toString());
			e2.printStackTrace();
		}

	}

	/*
	 * This method is used to find the difference between the Last mail Sent
	 * date and
	 */
	public boolean buildFailureTimeGapBeforeSendingEmail(Map<String, String> config) throws Exception {

		if (FranconnectUtil.timeofBuildFailure == 0) {
			return true;
		} else {
			long prevTime = FranconnectUtil.timeofBuildFailure;
			long curTime = System.currentTimeMillis();
			long timeDif = curTime - prevTime;

			if (timeDif > 900000) { // 15 Minutes
				FranconnectUtil.timeofBuildFailure = System.currentTimeMillis();
				return true;
			}
		}
		return false;
	}

	/*
	 * This method is used to current date for reporting purpose
	 */
	public String getCurrentDateForReport() {
		SimpleDateFormat sdfDate = new SimpleDateFormat("dd/MMM/yyyy");
		Date now = new Date();
		String strDate = sdfDate.format(now);
		return strDate;
	}

	/*
	 * this method is to print the map key and value
	 */
	public void printMap(Map<String, String> config) {

		for (Entry<String, String> entry : config.entrySet()) { // print keys
																// and values
			System.out.println(entry.getKey() + " : " + entry.getValue());
		}

		System.out.println("_____________________________________________________");
	}

	/*
	 * This method runs the test
	 */
	private void runTest(String suiteXML) throws Exception {
		try {
			TestNG tng = new TestNG();
			tng.setOutputDirectory(FranconnectUtil.config.get("testReportPath"));
			List<String> testsuites = Lists.newArrayList();
			File file = new File(suiteXML);
			String finaltestsuitepath = file.getAbsolutePath();
			testsuites.add(finaltestsuitepath);
			tng.setTestSuites(testsuites);

			try {
				tng.run();
			} catch (Exception e) {
				Reporter.log(e.getMessage());
				Thread.sleep(60000);
			}

		} catch (Exception e) {
			System.out.println(e.getMessage());
			Reporter.log(e.getMessage());
		}
	}

	public Document loadXMLFromString(String xml) throws Exception {
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = factory.newDocumentBuilder();
		InputSource is = new InputSource(new StringReader(xml));
		return builder.parse(is);
	}

	public String getValFromXML(String xmlStr, String tagName) throws Exception {
		String value = "";
		Document doc = loadXMLFromString(xmlStr);
		doc.getDocumentElement().normalize();
		NodeList ag = doc.getElementsByTagName("fcResponse");

		for (int temp = 0; temp < ag.getLength(); temp++) {

			org.w3c.dom.Node nNode = ag.item(temp);

			// System.out.println("\nCurrent Element :" + nNode.getNodeName());
			try {
				if (nNode.getNodeType() == org.w3c.dom.Node.ELEMENT_NODE) {
					Element eElement = (Element) nNode;
					value = eElement.getElementsByTagName(tagName).item(0).getTextContent();
				}
			} catch (Exception e) {

			}
		}
		return value;
	}
}

	
	
	
	
