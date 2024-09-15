import java.io.*;

public class App3 {
    public static void main(String[] args) throws Exception {

        Employee employee = new Employee("田中一郎", 41);
        DeptLeader leader = new DeptLeader("総務部", employee);

        System.out.println("部署: " + leader.getName() 
        + " リーダー: " + leader.getLeader().getName() 
        + " 年齢: " + leader.getLeader().getAge());

        FileOutputStream fos = new FileOutputStream("company.dat");
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(leader);
        oos.flush();
        oos.close();

        FileInputStream fis = new FileInputStream("company.dat");
        ObjectInputStream ois = new ObjectInputStream(fis);
        DeptLeader leader2 = (DeptLeader)ois.readObject();

        ois.close();

        System.out.println("部署: " + leader2.getName() 
        + " リーダー: " + leader2.getLeader().getName() 
        + " 年齢: " + leader2.getLeader().getAge());

        if(leader.equals(leader2) == true) {
            System.out.println("復元成功");
        } else {
            System.out.println("復元失敗");
        }
    }
}
