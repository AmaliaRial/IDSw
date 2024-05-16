<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
    <xsl:output method="html" encoding="UTF-8" doctype-public="-//W3C//DTD XHTML 1.0 Strict//EN" doctype-system="http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd" indent="yes"/>
    
    <xsl:template match="/MedicalRecord">
        <html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en" lang="en">
            <head>
                <meta name="author" content="Your Name" />
                <meta http-equiv="content-type" content="text/html;charset=UTF-8" />
                <title>Medical Record</title>
                <style>
					.content {
					display: grid;
					grid-template-columns: 1fr auto; /* Adjusted to position the
					title on the left and the patient info box on the right */
					align-items: flex-start; /* Aligns content to the top */
					}
					.header {
					grid-column: 1; /* Title positioned on the first column */
					margin-bottom: 10px; /* Add bottom margin to the header */
					}
					.patient-info {
					position: relative;
					z-index: 1;
					background-color: #fff;
					padding: 5px;
					border: 1px solid #000;
					width: fit-content;
					grid-column: 2; /* Adjusted to position on the right */
					grid-row: 1; /* Positioned on the first row */
					align-self: flex-start; /* Aligns to the top */
					margin-left: auto; /* Moves the box to the right */
					margin-right: 20px; /* Adds more right margin to move the
					box closer to the right corner */
					}
					.diagnosis {
					background-color: #f0f8ff; /* Light blue background color */
					border-radius: 5px; /* Rounded corners */
					padding: 10px; /* Add padding */
					margin-bottom: 10px; /* Add margin between diagnoses */
					}
					.patient-info p {
					font-size: smaller; /* Adjust font size of paragraph text */
					margin: 0; /* Remove default paragraph margins */
					}
					.patient-info h2 {
					margin: 0; /* Remove default heading margins */
					margin-bottom: 5px; /* Add a small margin below heading */
					}
					.h1 {
					font-size: x-large; /* Increase font size of h1 */
					}
					.treatment {
					background-color: #f2f2f2; /* Grey background color */
					border-radius: 5px; /* Rounded corners */
					padding: 10px; /* Add padding */
					margin-top: 10px; /* Adjusted margin for treatments */
					}
					.treatment p {
					margin-left: 20px; /* Adjusted margin for treatment comments
					*/
					}
					h2.diagnoses-title {
					font-size: larger; /* Increase font size */
					}
                </style>
            </head>
            <body>
                <div class="content">
                    <div class="header">
                        <h1>Medical Record</h1>
                    </div>
                    <div class="patient-info">
                        <h2>Patient Information:</h2>
                        <p>ID: <xsl:value-of select="Patient/@idPatient"/></p>
                        <p>Date of Birth: <xsl:value-of select="Patient/dob"/></p>
                        <p>Name: <xsl:value-of select="Patient/namePatient"/></p>
                        <p>Surname: <xsl:value-of select="Patient/surname"/></p>
                    </div>
                </div>
                <h2 class="diagnoses-title">Diagnoses:</h2>
                <xsl:apply-templates select="Diagnoses/Diagnosis"/>
            </body>
        </html>
    </xsl:template>
    
    <xsl:template match="Diagnosis">
        <div class="diagnosis">
            <h3><xsl:value-of select="@nameDiagnosis"/></h3>
            <p>Date: <xsl:value-of select="date"/></p>
            <p>Disease: <xsl:value-of select="disease/nameDisease"/></p>
            <p>Cause: <xsl:value-of select="disease/cause"/></p>
            <p><i>Additional Information: <xsl:value-of select = "disease/disease_comment_section"/></i></p>
            <xsl:apply-templates select="Treatment"/>
            <p>Comment: <xsl:value-of select="diagnosis_comment_section"/></p>
        </div>
    </xsl:template>
    
    <xsl:template match="Treatment">
        <div class="treatment">
            <h4>Treatment: <xsl:value-of select="nameTreatment"/></h4>
            <p>Comments: <xsl:value-of select="treatment_comment_Section"/></p>
        </div>
    </xsl:template>
</xsl:stylesheet>
