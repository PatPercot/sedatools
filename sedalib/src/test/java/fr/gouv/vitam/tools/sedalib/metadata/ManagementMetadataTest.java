package fr.gouv.vitam.tools.sedalib.metadata;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

import org.junit.jupiter.api.Test;

import fr.gouv.vitam.tools.sedalib.utils.SEDALibException;

import java.util.Date;

class ManagementMetadataTest {

	@Test
	void test() throws SEDALibException {
        //Given
        ManagementMetadata mm = new ManagementMetadata();

        // When loaded with all different kind of metadata

        // Test SchemeType metadata
        mm.addNewMetadata("ArchivalProfile", "TestArchivalProfile", "TestSchemeAgencyID", "TestSchemeAgencyName",
                "TestSchemeDataURI", "TestSchemeID", "TestSchemeName", "TestSchemeURI", "TestSchemeVersionID");

        // Test StringType metadata
        mm.addNewMetadata("OriginatingAgencyIdentifier", "TestOriginatingAgencyIdentifier");
        mm.addNewMetadata("SubmissionAgencyIdentifier", "TestSubmissionAgencyIdentifier");

        // Test RuleType metadata
        mm.addNewMetadata("AccessRule", "TestAccRule1)", new Date(0));
        AppraisalRule appraisalRule = new AppraisalRule();
        appraisalRule.addRule("TestAppRule1", new Date(0));
        appraisalRule.setPreventInheritance(true);
        appraisalRule.addRule("TestAppRule2");
        appraisalRule.addRefNonRuleId("TestAppRule3");
        appraisalRule.setFinalAction("Keep");
        mm.addMetadata(appraisalRule);

        // ...other types all tested in Management metadata

        String mmOut = mm.toString();
//        System.out.println("Value to verify=" + mmOut);

        // Test read write in XML string format
        ManagementMetadata mmNext = (ManagementMetadata) SEDAMetadata.fromString(mmOut, ManagementMetadata.class);
        String mmNextOut = mmNext.toString();

        // Then
        String testOut = "<ManagementMetadata>\n" +
                "  <ArchivalProfile schemeAgencyID=\"TestSchemeAgencyID\" schemeAgencyName=\"TestSchemeAgencyName\" schemeDataURI=\"TestSchemeDataURI\" schemeID=\"TestSchemeID\" schemeName=\"TestSchemeName\" schemeURI=\"TestSchemeURI\" schemeVersionID=\"TestSchemeVersionID\">TestArchivalProfile</ArchivalProfile>\n" +
                "  <OriginatingAgencyIdentifier>TestOriginatingAgencyIdentifier</OriginatingAgencyIdentifier>\n" +
                "  <SubmissionAgencyIdentifier>TestSubmissionAgencyIdentifier</SubmissionAgencyIdentifier>\n" +
                "  <AppraisalRule>\n" +
                "    <Rule>TestAppRule1</Rule>\n" +
                "    <StartDate>1970-01-01</StartDate>\n" +
                "    <Rule>TestAppRule2</Rule>\n" +
                "    <PreventInheritance>true</PreventInheritance>\n" +
                "    <RefNonRuleId>TestAppRule3</RefNonRuleId>\n" +
                "    <FinalAction>Keep</FinalAction>\n" +
                "  </AppraisalRule>\n" +
                "  <AccessRule>\n" +
                "    <Rule>TestAccRule1)</Rule>\n" +
                "    <StartDate>1970-01-01</StartDate>\n" +
                "  </AccessRule>\n" +
                "</ManagementMetadata>";
        assertThat(mmNextOut).isEqualTo(testOut);
    }
}
