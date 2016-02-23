package pages.dialogs;

import org.openqa.selenium.WebElement;

/**
 * Created by Archie on 22.02.2016.
 */
public class LoginDialog extends BaseDialog<LoginDialog>
{
    public WebElement getLoginFormEmailInput()
    {
        return FilterElementByCustomParameter(waitForElementsBySelector("input.auth-form__input"), "name", "email");
    }

    public WebElement getLoginFormPasswordInput()
    {
        return FilterElementByCustomParameter(waitForElementsBySelector("input.auth-form__input"), "name", "password");
    }

    public WebElement getSignInButton()
    {
        return waitForElementBySelector("button.auth-form__button>span");
    }
}
