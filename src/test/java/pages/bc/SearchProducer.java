package pages.bc;

import org.openqa.selenium.By;

public class SearchProducer {
    public By Summary_ProducerName = By.xpath("//div[@id='ProducerDetail-ProducerDetailScreen-ProducerDetailDV-Name']/descendant::div[last()]");

    public String getLocator(String key){
        switch (key){
            case "Producer":
                return "//div[@id='TabBar-ProducersTab']//div[@aria-label='Producer']";

            case "Search":
                return "//div[@id='Producers-ProducerSearchScreen-ProducerSearchDV-SearchAndResetInputSet-SearchLinksInputSet-Search']";

            default:
                return key;
        }
    }
}
