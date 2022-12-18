package DB;

import java.sql.*;
import java.util.ArrayList;

public class DataBase {








    public Connection setConnection(){
        Connection   dbConnection;
        {
            try {
               dbConnection = DriverManager.getConnection("jdbc:sqlserver://;databaseName=BusBook;trustServerCertificate=true;", "sa","root");
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }

        return  dbConnection;

    }

    public void setAdmin(String fName,String lName,String phone, String email,String password){



        //TODO: Validate lastName and title

        // 3. Add to DB
        try{
            // 3.1 Set Connection
            // 3.2 Add record in Employee table
            PreparedStatement p = setConnection().prepareStatement("INSERT INTO ADMIN1(fName,lName,email,passwords) VALUES (?,?,?,?);");
            p.setString(1, fName);
            p.setString(2, lName);
            p.setString(3, email);
            p.setString(4,password);
            int rowsInserted = p.executeUpdate();


            if(rowsInserted > 0){
                // jLabel5.setText("Employee added successfully.");
                //  jLabel5.setForeground(Color.green);
            }
        }catch(SQLException e){
            System.out.println("Ooops! Failed to create employee, Please contact support that there an issue while saving new employee.");
            // jLabel5.setForeground(Color.red);
        }


    }


    public void setCustomer(String name,String phone,String date){




        try{
            // 3.1 Set Connection
            // 3.2 Add record in Employee table
            PreparedStatement p = setConnection().prepareStatement("INSERT INTO CUSTOMER1(cName,cPhone,cRoot,cDate) VALUES (?,?,?,?);");
            p.setString(1, name);
            p.setString(2, phone);
            p.setString(3,"london");
            p.setString(4, date);
            int rowsInserted = p.executeUpdate();


            if(rowsInserted > 0){
                // jLabel5.setText("Employee added successfully.");
                //  jLabel5.setForeground(Color.green);
            }
        }catch(SQLException e){
            System.out.println("Ooops! Failed to create employee, Please contact support that there an issue while saving new employee.");
            // jLabel5.setForeground(Color.red);
        }


    }


    public void addBuses(String busID,String root,String price,String time) {


        try {
            // 3.1 Set Connection
            // 3.2 Add record in Employee table
            PreparedStatement p = setConnection().prepareStatement("INSERT INTO BUSES1(bID,bRoot,bPrice,bTime) VALUES (?,?,?,?);");

            p.setString(1, busID);
            p.setString(2, root);
            p.setString(3, price);
            p.setString(4, time);
            int rowsInserted = p.executeUpdate();


            if (rowsInserted > 0) {
                // jLabel5.setText("Employee added successfully.");
                //  jLabel5.setForeground(Color.green);
            }
        } catch (SQLException e) {
            System.out.println("Ooops! Failed to create employee, Please contact support that there an issue while saving new employee.");
            // jLabel5.setForeground(Color.red);
        }

    }

        public ArrayList<String> getCustomer(){


        ArrayList<String> customer=new ArrayList<>();
        try {

            PreparedStatement st = setConnection().prepareStatement("SELECT * FROM CUSTOMER1");
            ResultSet rs = st.executeQuery();

            Integer i=0;
            while (rs.next()) {
               i=i+1;

                System.out.println(i);
                customer.add("Customer#"+i.toString()+"       "+rs.getString("cName")+  "              " +
                        " "+rs.getString("cPhone")+"                 "+  rs.getString("cRoot"));





            }


        }catch (Exception io){


System.out.println("No Data For Fetching");
        }

        return customer;




}





    public ArrayList<String> getBuse(){


        ArrayList<String> buses=new ArrayList<>();
        try {

            PreparedStatement st = setConnection().prepareStatement("SELECT * FROM BUSES1");
            ResultSet rs = st.executeQuery();

            Integer i=0;

            while (rs.next()) {
                i=i+1;

                System.out.println(i);
                buses.add(i.toString()+ "    :    "+     rs.getString("bID")+  "                "
                                +rs.getString("bRoot")+"                "+
                               "                   "+ rs.getString("bPrice")+"             "+
                        rs.getString("bTime")
                        );





            }


        }catch (Exception io){


            System.out.println("No Data For Fetching");
        }

        return buses;




    }




    public ArrayList<String> getBusesId(){


        ArrayList<String> busesID=new ArrayList<>();
        try {

            PreparedStatement st = setConnection().prepareStatement("select bID from BUSES1");
            ResultSet rs = st.executeQuery();

            Integer i=0;

            while (rs.next()) {
                i=i+1;

                System.out.println(i);

                busesID.add(i.toString()+ "    :    "+     rs.getString("bID")+  "                "

                );





            }


        }catch (Exception io){


            System.out.println("No Data For Fetching");
        }

        return busesID;




    }






}











