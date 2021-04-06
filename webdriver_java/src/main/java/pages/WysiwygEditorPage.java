package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class WysiwygEditorPage {
    private WebDriver driver;
    private String editorIframeId = "mce_0_ifr"; /*esta vez no uso var*/
    private By textArea = By.id("tinymce");
    private By decreaseIdentButton = By.xpath("//button[@aria-label='Align left']");
    public WysiwygEditorPage(WebDriver driver) {
        this.driver = driver;
    }
    private void switchToEditArea(){
        driver.switchTo().frame(editorIframeId);
    }
    public void clearTextArea(){
        switchToEditArea();
        driver.findElement(textArea).clear();
        switchToMainArea();
    }
    public void setTextArea(String text){
        switchToEditArea();
        driver.findElement(textArea).sendKeys(text);
        switchToMainArea();
    }
    public void decreaseIdentation(){
        driver.findElement(decreaseIdentButton).click();

    }
    public String getTextFromEditor(){
        switchToEditArea();
        String text = driver.findElement(textArea).getText();
        switchToMainArea();
        return text;
    }
    private void switchToMainArea(){
        driver.switchTo().parentFrame();
    }
}
