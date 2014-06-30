package thread;

public class FetchMoneyTest
{
    public static void main(String[] args)
    {
        Bank bank = new Bank();

        Thread t1 = new MoneyThread(bank);// ������ȡǮ
        Thread t2 = new MoneyThread(bank);// ��ȡ���ȡǮ

        t1.start();
        t2.start();

    }

}

class Bank
{
    private int money = 1000;

    public synchronized int getMoney(int number)
    {
        if (number < 0)
        {
            return -1;
        }
        else if (number > money)
        {
            return -2;
        }
        else if (money < 0)
        {
            return -3;
        }
        else
        {
            try
            {
                Thread.sleep(1000);
            }
            catch (InterruptedException e)
            {
                e.printStackTrace();
            }
            money -= number;

            System.out.println("Left Money: " + money);
            return number;
        }
    }

}

class MoneyThread extends Thread
{
    private Bank bank;
    private int i=0;

    public MoneyThread(Bank bank)
    {
        this.bank = bank;
    }

    @Override
    public void run()
    {
    	i++;
    	System.out.println(i);
        System.out.println(bank.getMoney(800));
    }
}