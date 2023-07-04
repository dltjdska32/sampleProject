package Sample12;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Random;
public class CustomerManagement extends Account {
   private ArrayList<Customer> customers;
   private ArrayList<Account> accounts;

    public CustomerManagement(String ID, String password, String name, String pNum,
                              String address, long accountNum, String accountPassword, double balance) {
        super(ID, password, name, pNum, address,
                accountNum, accountPassword, balance);

        customers = new ArrayList<>();
        accounts = new ArrayList<>();
    }

    Customer c = new Customer();
    Account a = new Account();
    public CustomerManagement(){
        customers = new ArrayList<>();
        accounts = new ArrayList<>();
    }
   public void addCustomer(Customer customer){
       customers.add(customer);
   }

   public void removeCustomer(Customer customer) {
       boolean b = true;
       while(b) {
           System.out.println("아이디를 삭제하시겠습니까? y/n");
           String yesOrNo = sc.next();

           switch (yesOrNo) {
               case "y":

                        System.out.println("아이디와 비밀번호를 입력하십시오.");
                        System.out.print("ID : ");
                        String inID = sc.next();
                        System.out.print("PASSWORD : ");
                        String inPassword = sc.next();

                        int accountIndex = getAccountIndex(inID);
                        if(accountIndex == -1){
                            System.out.println("계좌가 없어 아이디만 삭제합니다.");
                            customers.remove(customer);
                        }

                        for (int i = 0; i < accounts.size(); i++) {
                               if (accounts.get(getAccountIndex(inID)).ID().equals(inID)) {

                                   customers.remove(customer);
                                   accounts.remove(accounts.get(getAccountIndex(inID)));
                                   System.out.println("아이디와 계좌 모두 삭제되었습니다.");
                               }
                        }

                   return;
               case "n":
                   System.out.println("옵션페이지로 돌아갑니다.");
                   showMainMenu(customer);
                   return;

               default:
                   System.out.println("입력값이 올바르지 않습니다.");
                   break;
               }
           }
       }





   public void addAccount(Customer customer, Account account){
        accounts.add(account);
   }
   public Customer getCustomer(int index){
       return customers.get(index);
   }

   public int getSize(){
       return customers.size();
   }

   public void createCustomer(){
        Scanner sc = new Scanner(System.in);
        System.out.print("생성할 ID를 입력하세요 : ");
        String input = sc.next();

       for(int i = 0; i < customers.size(); i++){
            if(input.equals(customers.get(i).ID())){
                System.out.println("아이디가 중복됩니다.\n다른 아이디를 입력하십시오 : ");
                input = sc.next();

                while(input.equals(customers.get(i).ID())){
                    System.out.println("아이디가 중복됩니다.\n다른 아이디를 입력하십시오 : ");
                    input = sc.next();
                }

            }

        }



       System.out.print("password를 입력하십시오 : ");
       String password = sc.next();

       System.out.print("이름을 입력하십시오 : ");
       String name = sc.next();

       System.out.print("핸드폰 번호를 입력하십시오 : ");
       String pNum = sc.next();

       System.out.print("주소를 입력하십시오 : ");
       String address = sc.next();

       Customer newCustomer = new Customer(input, password, name, pNum, address);
       customers.add(newCustomer);
       System.out.println("고객정보를 생성하였습니다. ");
   }

   public void createAccount(Customer customer) {
       System.out.println("계좌를 생성하시겠습니까? y / n");
       String yesOrNo = sc.next();
       boolean b = true;

       while (b) {

           if (yesOrNo.equals("y")) {
               System.out.println("계좌를 생성합니다");
               Random rd = new Random();
               long number = rd.nextLong();
               long thirteenNum = Math.abs(number) % (long) Math.pow(10, 12);
               System.out.println("계좌번호는 " + thirteenNum + "입니다. ");

               System.out.println("사용할 계좌 비밀번호를 입력하십시오 (네자리)");
               String accountP = sc.next();

               while (accountP.length() != 4) {
                   System.out.println("입력값이 네자리수가 아닙니다. \n비밀번호를 다시 입력하십시오 : ");
                   accountP = sc.next();
               }

               Account newAccount = new Account(customer.ID(), customer.password(), customer.name(),
                       customer.pNum(), customer.address(), thirteenNum, accountP, balance());

               customer.setAccount(newAccount);
               addAccount(customer, newAccount);

               System.out.println("계좌가 생성되었습니다.");

               return;

           } else if (yesOrNo.equals("n")) {
               System.out.println("옵션페이지로 돌아갑니다.");
               return;
           } else {
               System.out.println("입력값이 올바르지 않습니다.");
           }

           System.out.println("계좌를 생성하시겠습니까? y / n");
           yesOrNo = sc.next();
       }
   }

   public void transfer(Account account){

       System.out.println("이체할 계좌번호를 입력하시오. : ");
       long accountNumber = sc.nextLong();



       System.out.println("이체할 금액을 입력하십시오. : ");
       double transeferMoney = sc.nextDouble();



       for(int i = 0; i < accounts.size(); i++){
           if(accounts.get(i).accountNum() == accountNumber){
               if(account.balance() < transeferMoney){
                   System.out.println("잔액이 모자랍니다.");
               }else {
                   account.setBalance(account.balance() - transeferMoney);
                   accounts.get(i).setBalance(accounts.get(i).balance() + transeferMoney);

                   System.out.println("이체 완료했습니다.");
                   return;
               }
           }
       }



   }

   public void login() {

        System.out.print("ID : ");
        String inID = sc.next();
        System.out.print("PASSWORD : ");
        String inPassword = sc.next();


        for(int i = 0; i < customers.size(); i++) {
            if (customers.get(i).ID().equals(inID) && customers.get(i).password().equals(inPassword)) {

                boolean b = true;
                System.out.println("로그인에 성공하였습니다.");

                while (b) {

                    System.out.println("1. 계좌 생성 / 2. 잔액 조회 / 3. 계좌 이체 / 4. 입금 / 5. 출금 / 6. 아이디 삭제 / 7. 로그아웃");
                    System.out.print("옵션을 선택하십시오. : ");

                    int optionNum = sc.nextInt();

                    switch (optionNum) {
                        case 1:
                            createAccount(customers.get(i));
                            System.out.println(accounts.get(i).toString());
                            break;

                        case 2:
                            accounts.get(getAccountIndex(customers.get(i).ID())).balanceCheck();
                            break;

                        case 3:
                            transfer(accounts.get(getAccountIndex(customers.get(i).ID())));
                            break;

                        case 4:
                                accounts.get(getAccountIndex(customers.get(i).ID())).deposit();

                            break;
                        case 5:
                                accounts.get(getAccountIndex(customers.get(i).ID())).withdraw();

                            break;
                        case 6:
                            removeCustomer(customers.get(i));

                            return;

                        case 7:
                            b = false;
                            break;

                        default:
                            System.out.println("입력값이 잘못되었습니다.");
                            break;
                    }
                }



            } else if(!customers.get(i).ID().equals(inID) || !customers.get(i).password().equals(inPassword)){
                System.out.println("아이디 또는 비밀번호가 일치하지 않습니다.");
            }

        }
   }


    public void showMainMenu(Customer customer) {
        boolean b = true;
        int i = getCustomerIndex(customer.ID());
        while (b) {

            System.out.println("1. 계좌 생성 / 2. 잔액 조회 / 3. 계좌 이체 / 4. 입금 / 5. 출금 / 6. 아이디 삭제 / 7. 로그아웃");
            System.out.print("옵션을 선택하십시오. : ");

            int optionNum = sc.nextInt();

            switch (optionNum) {
                case 1:
                    createAccount(customers.get(i));
                    System.out.println(accounts.get(i).toString());
                    break;

                case 2:
                    accounts.get(getAccountIndex(customers.get(i).ID())).balanceCheck();
                    break;

                case 3:
                    transfer(accounts.get(getAccountIndex(customers.get(i).ID())));
                    break;

                case 4:
                    accounts.get(getAccountIndex(customers.get(i).ID())).deposit();

                    break;
                case 5:
                    accounts.get(getAccountIndex(customers.get(i).ID())).withdraw();

                    break;
                case 6:
                    removeCustomer(customers.get(i));

                    return;

                case 7:
                    b = false;
                    break;

                default:
                    System.out.println("입력값이 잘못되었습니다.");
                    break;
            }
        }



    }


    private int getAccountIndex(String customerID){
        for(int i = 0; i < accounts.size(); i++){
            if(accounts.get(i).ID().equals(customerID)){
                return i;
            }
        }
      return -1;
    }

    private int getCustomerIndex(String customerID){
        for(int i = 0; i < customers.size(); i++){
            if(customers.get(i).ID().equals(customerID)){
                return i;
            }
        }
        return -1;
    }

   public String toString(){
        return customers.toString();
   }

}
