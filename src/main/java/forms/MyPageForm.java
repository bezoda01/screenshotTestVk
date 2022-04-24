package forms;

import aquality.selenium.browser.AqualityServices;
import aquality.selenium.elements.interfaces.IButton;
import aquality.selenium.elements.interfaces.ITextBox;
import aquality.selenium.forms.Form;
import org.openqa.selenium.By;

public class MyPageForm extends Form {

    private ITextBox userIdPost = null;
    private ITextBox userTextPost = null;
    private ITextBox userImgPost = null;
    private ITextBox userCommentOnPostId = null;
    private ITextBox userCommentOnPostMessage = null;
    private IButton userPostLike = null;
    private String pathToCorrectPost;

    public MyPageForm(String userId, String postId) {
        super(By.id("page_info_wrap"), "Users  page");
        pathToCorrectPost = "//div[@id = 'post" + userId + "_" + postId + "']";
    }

    public String getUserIdFromNewPost() {
        userIdPost = getElementFactory().getTextBox(By.xpath(pathToCorrectPost), "Element from new post, by id user");
        return userIdPost.getAttribute("data-post-id");
    }

    public String getTextFromNewPost() {
        userTextPost = getElementFactory().getTextBox(By.xpath(pathToCorrectPost + "//div[@class='wall_post_text zoom_text' or @class = 'wall_post_text']"), "Element from new post, by text message");
        return userTextPost.getText();
    }

    public String getPhotoIdFromEditPost() {
        userImgPost = getElementFactory().getTextBox(By.xpath(pathToCorrectPost+"//a[@class = 'page_post_thumb_wrap image_cover  page_post_thumb_last_column page_post_thumb_last_row']"),"Img in post");
        userImgPost.focus();
        return userImgPost.getAttribute("href");
    }

    public String getIdUserInComment() {
        userCommentOnPostId = getElementFactory().getTextBox(By.xpath(pathToCorrectPost+"//div[@class='reply_text']//div[@id]"),"Comment in correct post");
        if(!userCommentOnPostId.state().isDisplayed()) {
            AqualityServices.getElementFactory().getButton(By.xpath(pathToCorrectPost+"//span[@class = 'js-replies_next_label']"),"Comment stub").click();
        }
        return userCommentOnPostId.getAttribute("id");
    }

    public String getCommentMessage() {
        userCommentOnPostMessage = getElementFactory().getTextBox(By.xpath(pathToCorrectPost+"//div[@class = 'wall_reply_text']"),"Comment message");
        return userCommentOnPostMessage.getText();
    }

    public void addLikePost() {
        userPostLike = getElementFactory().getButton(By.xpath(pathToCorrectPost+"//div[@class = 'PostBottomActionContainer PostButtonReactionsContainer']"), "Like button");
        userPostLike.click();
    }

    public boolean checkIsPostDeleted() {
        userIdPost.state().waitForNotDisplayed();
        return true;
    }
}
