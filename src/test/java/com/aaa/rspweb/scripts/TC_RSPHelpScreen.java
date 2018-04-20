/*
package com.aaa.rspweb.scripts;

import com.aaa.accelerators.ReportControl;
import com.aaa.googledrive.ReportStatus;
import com.aaa.rspweb.lib.RSPCommonLib;
import com.aaa.rspweb.lib.RSPHelpLib;
import com.aaa.rspweb.lib.RSPHomeLib;
import com.aaa.rspweb.lib.RSPLoginLib;
import com.aaa.utilities.TestUtil;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.Hashtable;

public class TC_RSPHelpScreen extends RSPCommonLib {

    RSPHelpLib help=new RSPHelpLib();
    RSPLoginLib login=new RSPLoginLib();
    RSPHomeLib home=new RSPHomeLib();
    String[] linkNames;
    int totalCharacters;

    @Parameters({"StartRow","EndRow","nextTestJoin"})
    @Test()
    public void helpScreen(int StartRow,String EndRow,boolean nextTestJoin) throws Throwable {
        try
        {
            int intStartRow=StartRow;
            int intEndRow= ReportControl.fnGetEndRowCunt(EndRow, "RSPHelpScreen", TestData, "RSPWeb");
            for(int intCounter=intStartRow;intCounter<=intEndRow;intCounter++) {
                try {
                    fnOpenTest();
                    ReportStatus.fnDefaultReportStatus();
                    ReportControl.intRowCount = intCounter;
                    Hashtable<String, String> data = TestUtil.getDataByRowNo("RSPHelpScreen", TestData, "RSPWeb", intCounter);
                    this.reporter.initTestCaseDescription("CR Locations" + " From Iteration " + StartRow + " to " + EndRow);
                    reporter.SuccessReport("Iteration Number : ", "**************Iteration Number::  " + intCounter + "   **************");
                    navigateToApplication("RSP");
                    login.loginToRSP(data.get("LoginName"), data.get("Password"));
                    home.clickOnHelp();
                    linkNames=data.get("LinkNames").toString().split(",");
                    for(int number=0;number<linkNames.length;number++) {
                        help.clickOnLeftPanelLinks(linkNames[number]);
                        help.getSectionHeaders(linkNames[number]);
                    }
                    if(Arrays.asList(linkNames).contains("Feedback")) {
                        help.clickOnLeftPanelLinks(linkNames[Arrays.asList(linkNames).indexOf("Feedback")]);
                        linkNames=data.get("Category").toString().split(",");
                        for(int number=0;number<linkNames.length;number++) {
                            help.selectCategory(linkNames[number]);
                            help.sendTextToFeedback(data.get("FeedbackText"));
                            help.getTotalCharactersLeft();
                            totalCharacters=data.get("FeedbackText").length();
                            assertTrue(totalCharacters == 1000, "Total characters entered " + totalCharacters);
                            help.clickOnSend();
                            help.verificationOfMailSent();
                        }
                    }
                    home.clickOnSignOut();
                }
                catch(Exception e)
                {
                    ReportStatus.blnStatus=false;
                }
                ReportControl.fnEnableJoin();
                ReportStatus.fnUpdateResultStatus("RSP","1850",ReportStatus.strMethodName,intCounter,browser);
                fnCloseTest();
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
        ReportControl.fnNextTestJoin(nextTestJoin);
    }

}
*/
