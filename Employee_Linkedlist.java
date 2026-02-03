package Assignment_new;

import java.util.*;
class Employee {

    String name;
    int eid;
    String gender;
    int salary;
    static Employee root;
    Employee next;
    
    public Employee(String name, int eid, String gender, int salary){
        
        this.name=name;
        this.eid=eid;
        this.gender=gender;
        this.salary=salary;
        next=null;
       
    }
    
}
public class Employee_Linkedlist {
    Employee root;
    void createList(){
        root=null;
    }
    void insert(String name, int eid, String gender, int salary){

        Employee n=new Employee(name,eid,gender,salary);
        
        if(root==null){
            root=n;
        }
        else{
            n.next=root;
            root=n;
        }
    }
    void search_emp(int e){
        if(root==null){
            System.out.println("List empty");
        }
        else{
            Employee t=root;
            while(t!=null && t.eid!=e){
                t=t.next;
            }
            if(t==null){
                System.out.println(e +"Not found");
            }
            else{
                System.out.println(t.eid+"Found");
                System.out.println("Employee details: ID=" + t.eid + ", Name=" + t.name + ", Gender=" + t.gender + ", Salary=" + t.salary);
            }
        }
    }
    void delete_employee(int key) {
        if (root == null)
            System.out.println("Empty List");
        else {
            Employee t, t2;
            t = t2 = root;
            while (t != null && t.eid != key) {
                t = t.next;
            }
            if (t == null)
                System.out.println(key + " is not found in the list");
            else {
                if (t == root)
                    root = root.next;
                else if (t.next == null)
                    t.next = null;
                else
                    t2.next = t.next;
                System.out.println("Deleted:" + t.name);
            }
        }
    }
    void print_list() {
        if (root == null)
            System.out.println("List is empty");
        else {
            Employee t = root;
            System.out.print("List: ");
            while (t != null) {
                System.out.print("| [" + t.eid + "]" + t.name + " <" + t.gender + ">" + t.salary + "|->");
                t = t.next;
            }
        }
    }

    void updateSalary(int eid, int newSalary) {
    if (root == null) {
        System.out.println("List is empty");
        return;
    }

    Employee t = root;
    while (t != null && t.eid != eid) {
        t = t.next;
    }

    if (t == null) {
        System.out.println("Employee not found");
    } else {
        t.salary = newSalary;
        System.out.println("Salary updated successfully");
    }
}



    void highestSalaryEmployee() {
    if (root == null) {
        System.out.println("List is empty");
        return;
    }

    Employee t = root;
    Employee max = root;

    while (t != null) {
        if (t.salary > max.salary) {
            max = t;
        }
        t = t.next;
    }

    System.out.println("Highest Salary Employee:");
    System.out.println("ID: " + max.eid + ", Name: " + max.name + ", Salary: " + max.salary);
}




    void reverseList() {
    Employee prev = null;
    Employee curr = root;
    Employee next;

    while (curr != null) {
        next = curr.next;
        curr.next = prev;
        prev = curr;
        curr = next;
    }
    root = prev;
    System.out.println("List reversed");
}


        

        

    public static void main(String[] args) {
      int ch;
      Scanner in = new Scanner(System.in);
      Employee_Linkedlist obj = new Employee_Linkedlist();
      obj.createList();
      do {
          System.out.println("1. Insert\n2. Search\n3. Print\n4. Delete\n0. Exit\nEnter your choice");
          ch = in.nextInt();
          switch (ch) {
              case 1:
                  
                  System.out.println("Enter name");
                  String n=in.next();
                  System.out.println("enter eid");
                  int e =in.nextInt();
                  System.out.println("Enter your gender");
                  String g=in.next();
                  System.out.println("enter salary");
                  int s=in.nextInt();
                  obj.insert(n,e,g,s);
                  break;
              case 2:  
                  System.out.println("Enter id to search");
                   obj.search_emp(in.nextInt());
                  break;
              case 3:
                  obj.print_list();
                  break;
              case 4:
                System.out.println("Enter employee id to be deleted");
                obj.delete_employee(in.nextInt());
                  break;
              default:
                  System.out.println("Invalid choice");
                  break;
             
                
          }
        }while(ch!=0);
    }
}

