import java.io.Serializable;

public class DeptLeader implements Serializable {
    private String name;
    private Employee leader;

    public DeptLeader (String name, Employee leader) {
        this.setName(name);
        this.setLeader(leader);
    }

    public String getName() {
        return this.name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public Employee getLeader() {
        return this.leader;
    }
    public void setLeader(Employee leader) {
        this.leader = leader;
    }

    public boolean equals(Object o) {
        //return EqualsBuilder.reflectionEquals(this, o);
        if (this == o) {
            return true;
        }
        if (o == null) {
            return false;
        }
        if (o instanceof DeptLeader) {
            DeptLeader d = (DeptLeader)o;
            if (this.getName().equals(d.getName())) {
                if (this.getLeader().getName().equals(d.getLeader().getName())) {
                    if (this.getLeader().getAge() == d.getLeader().getAge()) {
                        return true;
                    } else {
                        System.out.println("年齢不一致" + this.getLeader().getAge() + ":" + d.getLeader().getAge());
                        return false;
                    }
                } else {
                    System.out.println("リーダー名不一致" + this.getLeader() + ":" + d.getLeader());
                    return false;
                }
            } else {
                System.out.println("部署名不一致" + this.getName() + ":" + d.getName());
                return false;
            }
        } else {
            return false;
        }
    }
}
