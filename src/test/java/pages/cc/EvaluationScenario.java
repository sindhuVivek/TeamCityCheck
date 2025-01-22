package pages.cc;
import org.openqa.selenium.WebDriver;

public class EvaluationScenario {
    private WebDriver driver;

    public EvaluationScenario() {
        this.driver = driver;
    }
    public String getLocator(String key) {
        switch (key) {
            case "Claim":
                return "//div[@id='TabBar-ClaimTab']//descendant::div[contains(@class,'expand-button')]";
            case "ClaimNumber":
                return "//input[@name='TabBar-ClaimTab-ClaimTab_FindClaim']";
            case "ClaimFindBtn":
                return "//div[@id='TabBar-ClaimTab-ClaimTab_FindClaim_Button']";
            case "ActionMenu":
                return "//div[@id='Claim-ClaimMenuActions']";
            case "EvaluationBtn":
                return "//div[@id='Claim-ClaimMenuActions-ClaimNewOtherMenuItemSet-ClaimMenuActions_NewOther-ClaimMenuActions_NewEvaluation']";
            case "evaluationName":
                return "//input[@name='NewEvaluation-NewEvaluationScreen-NewEvaluationDV-SettlementCostEstimate_Name']";
            case "evaluationAmount":
                return "//input[@name='NewEvaluation-NewEvaluationScreen-NewEvaluationDV-TotalValue_Amount']";
            case "UpdateBtn":
                return "//div[@id='NewEvaluation-NewEvaluationScreen-Update']";
            case "PlanOfActionBtn" :
                return "//div[@id='Claim-MenuLinks-Claim_ClaimPlanOfActionGroup']";
            case "EvaluationsTab":
                return "//div[@id='Claim-MenuLinks-Claim_ClaimPlanOfActionGroup-ClaimPlanOfActionGroup_ClaimEvaluations']";
            case "EvaluationEdit":
                return "//div[@id='ClaimEvaluations-ClaimEvaluationsScreen-ClaimEvaluationDetailsDV_tb-Edit']";
            case "UpdateInsuredLiability":
                return "//input[@name='ClaimEvaluations-ClaimEvaluationsScreen-ClaimEvaluationDetailsDV-ClaimEvaluationDetailDV-LiabilityDistribution_InsuredLiability']";
            case "UpdateOtherLiability":
                return "//input[@name='ClaimEvaluations-ClaimEvaluationsScreen-ClaimEvaluationDetailsDV-ClaimEvaluationDetailDV-LiabilityDistribution_OtherLiability']";
            case "EditEvaluationsUpdate":
                return "//div[@id='ClaimEvaluations-ClaimEvaluationsScreen-ClaimEvaluationDetailsDV_tb-Update']";
            case "UpdateOtherLiabilityClick" :
                return "//input[@name='ClaimEvaluations-ClaimEvaluationsScreen-ClaimEvaluationDetailsDV-ClaimEvaluationDetailDV-LiabilityDistribution_OtherLiability']";
            case "SelectEvaluation":
                return "//div[@id='ClaimEvaluations-ClaimEvaluationsScreen-EditableEvaluationsLV-0-_Checkbox_checkboxDiv']";
            case "DeleteBtn":
                return "//div[@id='ClaimEvaluations-ClaimEvaluationsScreen-Remove']";
            default:
                return key;


        }
    }
}
