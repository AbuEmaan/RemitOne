package Helpers;

import managers.FileReaderManager;
import java.io.BufferedReader;

import java.io.FileNotFoundException;

import java.io.FileReader;

import java.io.IOException;

import java.util.Properties;
import Helpers.HelperFunctions;

public class TestRun {

	public static String testRunName;
	public static HelperFunctions helper = new HelperFunctions();

	public static void setTestRunName() {

		Properties prop = FileReaderManager.getInstance().getConfigReader().getProperties();

		String TRN = prop.getProperty("RestRunFolderName");

		testRunName = TRN + "_" + helper.getDateTime();

	}

	public static String getTestRunName() {

		return testRunName;

	}

}
