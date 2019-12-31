package com.atom.mockito.quickstart;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import javax.servlet.http.HttpServletRequest;

import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertThat;
import static org.mockito.Matchers.anyString;

/**
 * @author Atom
 */
@RunWith(MockitoJUnitRunner.class)
public class AccountLoginControllerTest {

    private AccountDao accountDao;
    private HttpServletRequest request;
    private AccountLoginController accountLoginController;

    @Before
    public void setUp() {
        this.accountDao = Mockito.mock(AccountDao.class);
        this.request = Mockito.mock(HttpServletRequest.class);
        this.accountLoginController = new AccountLoginController(accountDao);
    }

    @Test
    public void testLoginSuccess() {
        Account account = new Account();
        Mockito.when(request.getParameter("userName")).thenReturn("Atom");
        Mockito.when(request.getParameter("password")).thenReturn("123456");
        Mockito.when(accountDao.findAccount(anyString(), anyString())).thenReturn(account);
        assertThat(accountLoginController.login(request), equalTo("/index"));
    }


}
