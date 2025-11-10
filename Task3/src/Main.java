import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);


        System.out.println("=== 1 ====");
        ArrayList<String> names = new ArrayList<>();
        for(int i = 0;i<3;i++){
            System.out.println("Enter the name ");
            names.add(sc.nextLine());
        }
        Collections.sort(names);
        System.out.println("Names in the alphabetic order " + names);

        System.out.println("Enter the name to delete");
        String namesToRemove = sc.nextLine();
        names.remove(namesToRemove);
        System.out.println("Updated List " + names);


        System.out.println("=== 2 ===");
        HashSet<Integer> StudentIds = new HashSet<>();
        System.out.println("Total no. of id ");
        int n = sc.nextInt();
        for(int i = 0;i<n;i++){
            StudentIds.add(sc.nextInt());
        }
        System.out.println("Student id " + StudentIds);
        System.out.println("Enter an id to check ");
        int checkId = sc.nextInt();
        if(StudentIds.contains(checkId)){
            System.out.println("Existed");
        }
        else{
            System.out.println("Not Existed");
        }

        System.out.println("=== 3 ===");
        HashMap<String ,Integer> employees = new HashMap<>();
        System.out.println("enter the name and salary");
        for(int i = 0;i<3;i++){
            employees.put(sc.next(),sc.nextInt());
        }
        System.out.println("Employees : " + employees);
        System.out.println("Enter the name to update salary : ");
        String emp = sc.next();
        if(employees.containsKey(emp)){
            System.out.println("Enter the salary to update : ");
            employees.put(emp,sc.nextInt());
        }
        System.out.println("Updated employees : " + employees);
        System.out.println("Enter the name to delete ");
        employees.remove(sc.next());
        System.out.println("Final employees " + employees);

        System.out.println("=== 4 ===");
        LinkedList<String> todo = new LinkedList<>();
        while (true) {
            System.out.println("\n1. Add Task  2. Remove Task  3. View Tasks  4. Exit");
            int choice = Integer.parseInt(sc.nextLine());
            if (choice == 1) {
                System.out.print("Enter task: ");
                todo.add(sc.nextLine());
            } else if (choice == 2) {
                System.out.print("Enter completed task: ");
                todo.remove(sc.nextLine());
            } else if (choice == 3) {
                System.out.println("Current To-Do List: " + todo);
            } else break;
        }
        System.out.println("=== 5 ===");
        FileWriter fw = new FileWriter("notes.txt");
        System.out.println("Enter your notes (type 'stop' to finish):");
        while(true){
            String line = sc.nextLine();
            if(line.equalsIgnoreCase("stop")) break;
            fw.write(line + "\n");
        }
        fw.close();
        System.out.println("Notes saved to notes.txt. Reading file...");
        BufferedReader br = new BufferedReader(new FileReader("notes.txt"));
        String fileLine;
        while ((fileLine = br.readLine()) != null) {
            System.out.println(fileLine);
        }
        br.close();

        System.out.println("=== 6 ===");
        File file = new File("notes.txt");
        if(file.exists()){
            Scanner fileScanner = new Scanner(file);
            int wordCount = 0 ;
            while(fileScanner.hasNext()){
                fileScanner.next();
                wordCount++;
            }
            fileScanner.close();
            System.out.println("Total word : " + wordCount);
        }else{
            System.out.println("File not found");
        }

        System.out.println("=== 7 ===");
        System.out.println("\n=== Task 7: Copy Data from One File to Another ===");
        System.out.print("Enter source file name: ");
        String source = sc.nextLine();
        System.out.print("Enter destination file name: ");
        String dest = sc.nextLine();

        try (BufferedReader r = new BufferedReader(new FileReader(source));
             BufferedWriter w = new BufferedWriter(new FileWriter(dest))) {
            String text;
            while ((text = r.readLine()) != null) {
                w.write(text + "\n");
            }
            System.out.println("File copied successfully!");
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }

        System.out.println("=== 8 ===");
        ArrayList<String> contacts = new ArrayList<>();
        File contactList = new File("contact.txt");
        if(contactList.exists()){

            BufferedReader cbr = new BufferedReader(new FileReader(contactList));
            String cline ;
            while((cline = cbr.readLine()) != null){
                contacts.add(cline);
            }
            cbr.close();
        }
        while(true){
            System.out.println("\n1. Add Contact  2. Search Contact  3. View All  4. Exit");
            int choice = Integer.parseInt(sc.nextLine());
            if(choice == 1){
                System.out.println("Enter the name ");
                String cname = sc.nextLine();
                System.out.println("Enter the phone no. ");
                String cphone = sc.nextLine();
                contacts.add(cname + " - " + cphone);
            }else if(choice == 2){
                System.out.println("enter name to search ");
                String search = sc.nextLine();
                for(String c : contacts){
                    if(c.toLowerCase().contains(search.toLowerCase())){
                        System.out.println("found");
                    }
                }
            }else if(choice == 3){
                System.out.println("All contact " + contacts);
            }else{
                BufferedWriter cw = new BufferedWriter(new FileWriter(contactList));
                for(String c : contacts){
                    cw.write(c + "\n");
                }
                cw.close();
                System.out.println("Saved");
                cw.close();
                break;
            }
        }
        System.out.println("=== 9 ===");
        HashMap<String, Integer> studentRecords = new HashMap<>();
        File studentFile = new File("students.txt");

        // Read existing records
        if (studentFile.exists()) {
            BufferedReader sbr = new BufferedReader(new FileReader(studentFile));
            String sLine;
            while ((sLine = sbr.readLine()) != null) {
                String[] parts = sLine.split(",");
                if (parts.length == 2) {
                    studentRecords.put(parts[0], Integer.parseInt(parts[1]));
                }
            }
            sbr.close();
        }

        while (true) {
            System.out.println("\n1. Add Record  2. View All  3. Save & Exit");
            int choice = Integer.parseInt(sc.nextLine());
            if (choice == 1) {
                System.out.print("Enter student name: ");
                String sname = sc.nextLine();
                System.out.print("Enter marks: ");
                int marks = Integer.parseInt(sc.nextLine());
                studentRecords.put(sname, marks);
            } else if (choice == 2) {
                System.out.println("Student Records:");
                for (Map.Entry<String, Integer> e : studentRecords.entrySet()) {
                    System.out.println(e.getKey() + " -> " + e.getValue());
                }
            } else {
                BufferedWriter sw = new BufferedWriter(new FileWriter(studentFile));
                for (Map.Entry<String, Integer> e : studentRecords.entrySet()) {
                    sw.write(e.getKey() + "," + e.getValue() + "\n");
                }
                sw.close();
                System.out.println("Records saved to students.txt");
                break;
            }
        }

        sc.close();

    }
}