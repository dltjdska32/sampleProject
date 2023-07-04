    package Sample12;


    public class Account extends Customer{
            private long accountNum;
            private String accountPassword;
            private double balance;
            private Account account;


        public Account(String ID, String password, String name, String pNum, String address, long accountNum, String accountPassword, double balance){
            super(ID, password, name, pNum, address);
            this.accountNum = accountNum;
            this.accountPassword = accountPassword;
            this.balance = balance;
        }

        public Account(){};

        public long accountNum(){
            return accountNum;
        }
        public String accountPassword() {
            return accountPassword;
        }

        public Account setAccountPassword(String accountPassword) {
            this.accountPassword = accountPassword;
            return this;
        }

        public double balance() {
            return balance;
        }

        public Account setBalance(double balance) {
            this.balance = balance;
            return this;
        }



            public void balanceCheck(){
                    System.out.println("잔액은 " + balance + "원 입니다. ");
            }

            public double deposit(){
                System.out.print("입금할 금액을 입력하십시오. : ");
                double money = sc.nextDouble();

                this.balance += money;

                System.out.println("입금을 완료했습니다.");
                return this.balance;
            }

            public double withdraw() {
                System.out.print("출금할 금액을 입력하십시오. : ");
                double money = sc.nextDouble();
                if (this.balance() < money) {
                    System.out.println("잔액이 모자랍니다.");
                    return balance;
                } else {
                    this.balance -= money;

                    System.out.println("출금을 완료했습니다.");
                    return balance;
                }
            }


            public String toString(){
                return super.toString() + " " + accountNum + " " + accountPassword + " " + balance;
            }


        }



