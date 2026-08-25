import java.io.*;


//Klasse Mitarbeiter und ihre Attribute: name, email, password 
public class Employee {
	 protected static Employee stream;
	 String password	;																										
	 String name 	;																										
	 String email 	;	
	
	 //Konstruktor : bei der Erstellung 
	 	public Employee(String name, String email, String password ) throws IOException{														 		 
			 this.password = password;																								
			 this.name = name;																										
			 this.email = email; 
		}	
	/**
		 * 
		 * @return email
		 */
	 	public String getEmail() {
			return email;
		}
		/**
		 * 
		 * @return password
		 */
	 	public String getPassword() {
			return password;
		}
		
		
		/**
		 * 
		 * @return name
		 */
	 	public String getName() {
			return name;
		}
		/**
		 * 
		 * @return password,emai,name
		 */
		//fügt alle Attribute eines Mitarbeiter zu einem String zusammen
	 	public String employeeToString() {
			return this.getPassword()
					+ ";" + this.getEmail() 
					+ ";" + this.getName()  ;
					
		}
		/**
		 * 
		 * @param name
		 * @param email
		 * @param password
		 * @throws IOException
		 */
		//fügt Mitarbeiter Attribute in die Textdatei ein 
	 	public void EmployeeList(String name, String email, String password) throws IOException {											
			   File file = new File("Server/Mitarbeiter/Mitarbeiter.txt");
			   FileWriter fw = new FileWriter(file, true);																				
			   BufferedWriter bw = new BufferedWriter (fw);																				
			   PrintWriter pw = new PrintWriter (bw);																							   
			   pw.println(name+";"+email+";"+password);																 			   																															
			   pw.close();																												
			   bw.close();
			   fw.close();
			}
		/**
		 *  
		 * @param newname
		 * @param oldname
		 * @param email
		 * @param password
		 * @throws IOException
		 */ 
		//Ändern den Namen eines Mitarbeiters 
	 	public void editEmployeename(String newname, String oldname,String email, String password)throws IOException {																																					
			 removefromEmployeelist(oldname);																							
			 EmployeeList(newname,email,password);																			 		 		 
			 		 		 
		 }
		/**
		 *  
		 * @param newpassword
		 * @param oldpassword
		 * @throws IOException
		 */ 
		//Ändern das Password eines Mitarbeiters
		public void editEmployeepassword(String newpassword, String oldpassword)throws IOException {											
			 this.password = newpassword;																								
			 removefromEmployeelist(this.name);																							
			 EmployeeList( this.name,this.email,newpassword);																			 
			 		 		 
		}
		/**
		 *  
		 * @param newemail
		 * @param oldemail
		 * @throws IOException
		 */ 
		//Ändern die Email eines Mitarbeiters
		public void editEmployeeemail(String newemail, String oldemail)throws IOException {											
			 this.email = newemail;																										
			 removefromEmployeelist(this.name);																							
			 EmployeeList( this.name,newemail,this.password);																				 		 
			 		 
		}
		/**
		 *  
		 * @param name
		 * @param email
		 * @param password
		 * @throws IOException
		 */ 
		//Löscht alle Attribute aus dem Textdokument und setzt attribute auf null 
		public void deleteEmployee(String name, String email, String password)throws IOException{											
			 removefromEmployeelist(name);																							
			 password = null;																							
			 name = null;																											
			 email = null;																																																	 					
			 		
			  } 
		/**

		/**
		 * 
		 * @param name
		 * @param email
		 * @param password
		 * @return true
		 * Exception return false
		 */ 
		//Überprüft ob es das Mitarbeiterkonto in der Textdatei gibt
		public boolean allcheck(String name, String email, String password) {
				int position = 0;
				String searchname = name;
				String tocheck = name+";"+email+";"+password;
				String currentLine;																									
				String data[];
				try {FileReader fr = new FileReader ("Server/Mitarbeiter/Mitarbeiter.txt");
					BufferedReader br = new BufferedReader (fr);
					//Solange die Aktuelle gelesende Zeile nicht Leer ist 
						while ((currentLine = br.readLine()) != null){	
							data = currentLine.split(";");
							//Falls die Postion von dem gesuchten Namen gefunden ist Speicher die Zeile
							if((data[position].equalsIgnoreCase(searchname))) {
								String tocheckline = currentLine;
								//Falls die Zeile mit der Eingegebenen Daten übereinstimmt gibt wahr aus 
								if(tocheckline.equalsIgnoreCase(tocheck)) {
									br.close();									
									return true;
								}
								
							}
						}
						fr.close();																											
						br.close();
					}
					
					catch (Exception e)
					 {				 			 
				}
				return false;				 	
			}
		 
		 /**
		 * 
		 * @param removename
		 * @return new File
		 */
		 //Löscht den Mitarbeiter in dem Textdokument
		 public void removefromEmployeelist(String removename) {			 															
				 int position = 0 ;																										
				 String tempFile = "Server/Mitarbeiter/temp.txt";																							
				 File oldFile = new File("Server/Mitarbeiter/Mitarbeiter.txt");
				 File newFile = new File (tempFile);																					
				 
				 String currentLine;																									
				 String data[];																											
				 
				 try 
				 {
					FileWriter fw = new FileWriter(tempFile, true);																		
					BufferedWriter bw = new BufferedWriter (fw);																		
					PrintWriter pw = new PrintWriter (bw);																								
					FileReader fr = new FileReader ("Server/Mitarbeiter/Mitarbeiter.txt");
					BufferedReader br = new BufferedReader (fr);

					//Solange die Zeile nicht Leer ist			
					while ((currentLine = br.readLine()) != null)																		 
					{	
						
						data = currentLine.split(";");		
						//Falls die aktuelle Name nicht der Name ist der Entfernt werden soll schreibe in das Tempuräre Dokument																	
						if(!(data[position].equalsIgnoreCase(removename)))																
						{
							pw.println(currentLine);																					
						}	
						
					}
					pw.flush();																											
					pw.close();																											
					fr.close();																											
					br.close();
					bw.close();
					fw.close();
					
					//Löschen des Alten Dokument und Umbenennung des neuen Dokuments
					oldFile.delete();																									
					File dump = new File ("Server/Mitarbeiter/Mitarbeiter.txt");
					newFile.renameTo(dump);																								
									
				 }
				 catch (Exception e)
				 {				 			 
			}		 		 		 		 
		 }		 		 
		 }	


		

	 

		
