package com.coviam.internalapp.hrms.document.adapter;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import static com.coviam.internalapp.hrms.utils.TableUtils.*;

/**
 * Created by shailaja on 31/01/17.
 */
public class DocumentDataRetrieval {
    @SuppressWarnings({"unchecked", "rawtypes"})
    public static String DataRetrieval(String customerId, String docId, String employeeId) {
        Connection c = null;
        Statement stmt = null;
        String bodycontent = "";
        String filename = "";
        String filename1 = "";
        String filename2 = "";

        try {
            Class.forName("org.postgresql.Driver");
            c = DriverManager.getConnection(CONNECTION_STRING, USERNAME, PASSWORD);
            c.setAutoCommit(true);
            stmt = c.createStatement();

            String query = "SELECT document_body FROM document_gen WHERE document_gen_id = ?";
            PreparedStatement preparedStmtstart = c.prepareStatement(query);
            preparedStmtstart.setString(1, docId);
            ResultSet rsbody = preparedStmtstart.executeQuery();
            while (rsbody.next()) {
                bodycontent = rsbody.getString("document_body");
            }
            rsbody.close();

            HashMap<String, String> hmap1 = new HashMap<String, String>();
            hmap1.put("report_person_fullname", "SELECT report_person_fullname FROM reporting_contact_detail");
            hmap1.put("report_person_designation", "SELECT report_person_designation FROM reporting_contact_detail");
            hmap1.put("reporting_time", "SELECT reporting_time FROM reporting_contact_detail");
            hmap1.put("contact_person_fullname", "SELECT contact_person_fullname FROM reporting_contact_detail");
            hmap1.put("contact_person_phone", "SELECT contact_person_phone FROM reporting_contact_detail");
            hmap1.put("contact_person_email", "SELECT contact_person_email FROM reporting_contact_detail");
            hmap1.put("sign_authority_fullname", "SELECT sign_authority_fullname FROM reporting_contact_detail");
            hmap1.put("sign_authority_designation", "SELECT sign_authority_designation FROM reporting_contact_detail");


            ResultSet[] rs1 = new ResultSet[hmap1.size()];
            String[] hmapquery1 = new String[hmap1.size()];
            PreparedStatement[] preparedStmt1 = new PreparedStatement[hmap1.size()];

            List values1 = new ArrayList(hmap1.values());
            List keys1 = new ArrayList(hmap1.keySet());

            for (int i = 0; i < hmap1.size(); i++) {

                hmapquery1[i] = (String) values1.get(i);
                System.out.println(hmapquery1[i]);

                preparedStmt1[i] = c.prepareStatement(hmapquery1[i]);

                rs1[i] = preparedStmt1[i].executeQuery();

                while (rs1[i].next()) {
                    String retval = rs1[i].getString((String) keys1.get(i));
                    System.out.println(retval);
                    bodycontent = bodycontent.replaceAll((String) keys1.get(i), retval);
                }

                rs1[i].close();
            }

            HashMap<String, String> hmap = new HashMap<String, String>();
            hmap.put("degree", "SELECT degree FROM education_detail WHERE customer_id = ? AND employee_id = ?");
            hmap.put("email_id", "SELECT email_id FROM employee_detail WHERE customer_id = ? AND employee_id = ?");
            hmap.put("phone_number", "SELECT phone_number FROM employee_detail WHERE customer_id = ? AND employee_id = ?");
            hmap.put("name", "select name from employee_detail where customer_id=? and employee_id=?");

            hmap.put("address","SELECT address FROM location WHERE location_id =(SELECT location_id FROM employee_detail WHERE customer_id = ? and employee_id=?)");
            //hmap.put("edu_detail_institute","SELECT edu_detail_institute FROM education_detail WHERE customer_id = ? AND employee_id=? AND degree = (SELECT degree FROM educational_detail WHERE customer_id = ? AND employee_id = ?)");
            hmap.put("start_date","SELECT start_date FROM work WHERE customer_id = ? AND employee_id = ?");
            hmap.put("end_date","SELECT end_date FROM work WHERE customer_id = ? AND employee_id = ?");


            ResultSet[] rs = new ResultSet[hmap.size()];
            String[] hmapquery = new String[hmap.size()];
            PreparedStatement[] preparedStmt = new PreparedStatement[hmap.size()];


            List values = new ArrayList(hmap.values());
            List keys = new ArrayList(hmap.keySet());

            for (int i = 0; i < hmap.size(); i++) {

                hmapquery[i] = (String) values.get(i);
                System.out.println(hmapquery[i]);

                preparedStmt[i] = c.prepareStatement(hmapquery[i]);


                preparedStmt[i].setString(1, customerId);
                preparedStmt[i].setString(2, employeeId);

                rs[i] = preparedStmt[i].executeQuery();


                while (rs[i].next()) {
                    String retval = rs[i].getString((String) keys.get(i));
                    System.out.println(retval);
                    bodycontent = bodycontent.replaceAll((String) keys.get(i), retval);
                }

                rs[i].close();
            }

            String query1 = "UPDATE document_gen SET document_body = ? where document_gen_id = ?";
            PreparedStatement preparedStmtend = c.prepareStatement(query1);
            preparedStmtend.setString(1, bodycontent);
            preparedStmtend.setString(2, docId);

            preparedStmtend.executeUpdate();

            String query2 = "SELECT document_body FROM document_gen where document_gen_id = ?";
            PreparedStatement preparedStmtendchk = c.prepareStatement(query2);
            preparedStmtendchk.setString(1, docId);

            ResultSet rstestendchk = preparedStmtendchk.executeQuery();
            while (rstestendchk.next()) {
                String document_body = rstestendchk.getString("document_body");
                System.out.println("Body = " + document_body);
            }

            rstestendchk.close();

            String filenamequery = "SELECT document_name FROM document_gen WHERE document_gen_id = ?";
            PreparedStatement preparedStmtfilename = c.prepareStatement(filenamequery);
            preparedStmtfilename.setString(1, docId);
            ResultSet rsfilename = preparedStmtfilename.executeQuery();
            while (rsfilename.next()) {
                filename = rsfilename.getString("document_name");
                System.out.println(filename);
            }
            rsfilename.close();

            String filenamequery1 = "SELECT name FROM employee_detail WHERE customer_id = ? AND employee_id = ?";
            PreparedStatement preparedStmtfilename1 = c.prepareStatement(filenamequery1);
            preparedStmtfilename1.setString(1, customerId);
            preparedStmtfilename1.setString(2, employeeId);
            ResultSet rsfilename1 = preparedStmtfilename1.executeQuery();
            while (rsfilename1.next()) {
                filename1 = rsfilename1.getString("name");
                //  filename2 = rsfilename1.getString("last_name");
                System.out.println(filename1);
            }
            rsfilename1.close();

            //c.commit();
            stmt.close();
            //c.close();

        } catch (Exception e) {
            System.out.println(e);
            System.exit(0);
        }

        return filename + "_" + filename1;

    }

}
