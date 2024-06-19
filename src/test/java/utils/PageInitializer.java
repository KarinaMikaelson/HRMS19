package utils;

import Pages.AddEmployeePage;
import Pages.DashboardPage;
import Pages.EmployeeSearchPage;
import Pages.LoginPage;

public class PageInitializer {
   //Page Initializer we are creating for code reusability. We extend the CommonMethods class with Page Initializer
    //right after launching the browser we call the method initializePageObjects which is going to initialize all
    // the objects we created in that method and they will be available all the time everywhere
    //Now we don't need to create the object every time when we want to use any of our Page classes
        public static AddEmployeePage addEmployeePage;
        public static LoginPage loginPage;
        public static DashboardPage dashboardpage;
        public static EmployeeSearchPage employeeSearchPage;

        public static void initializePageObjects(){
            addEmployeePage=new AddEmployeePage();
            loginPage=new LoginPage();
            dashboardpage=new DashboardPage();
            employeeSearchPage=new EmployeeSearchPage();
        }

}
