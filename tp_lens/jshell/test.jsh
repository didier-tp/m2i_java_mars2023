var a=2
var b=3
var c=a+b

import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.io.*;

List<String> lignes = Files.readAllLines(FileSystems.getDefault().getPath("f1.txt"), StandardCharsets.UTF_8);
PrintStream ps = new PrintStream(new FileOutputStream("f2.txt"));
for (String ligne : lignes){
  String ligneMaj  = ligne.toUpperCase();
  System.out.println(ligneMaj);
  ps.println(ligneMaj);
 }
ps.close();

/exit