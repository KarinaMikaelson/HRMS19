package utils;

import Pages.*;

public class PageInitializer {
        public static AddEmployeePage addEmployeePage;
        public static LoginPage loginPage;
        public static DashboardPage dashboardpage;
        public static EmployeeSearchPage employeeSearchPage;
        public static AccessingMembershipSectionPage accessingMembershipSectionPage;
        public static ManageEmployeeMembershipPage manageEmployeeMembershipPage;


        public static void initializePageObjects(){
            addEmployeePage=new AddEmployeePage();
            loginPage=new LoginPage();
            dashboardpage=new DashboardPage();
            employeeSearchPage=new EmployeeSearchPage();
            accessingMembershipSectionPage = new AccessingMembershipSectionPage();
            manageEmployeeMembershipPage = new ManageEmployeeMembershipPage();
        }

}
