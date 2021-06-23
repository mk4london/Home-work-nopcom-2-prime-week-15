package resources.testdata;

import org.testng.annotations.DataProvider;

public class TestData
{
    @DataProvider(name = "credentials")
    public Object[][] getLoginData()
    {
        Object[][] data = new Object[][]{
                {"Test1@gmail.com","Test123"},
                {"Test2@gmail.com","Test456"},
              //  {"Test3@gmail.com","Test789"},
        };
        return data;
    }

//    @DataProvider(name = "topMenu")
//    public Object[] getTopMenuData()
//    {
//        String[] data = new String[]{
//                {"Test1@gmail.com"},
//                {"Test2@gmail.com"},
//                //  {"Test3@gmail.com","Test789"},
//        };
//        return data;
//    }

}
