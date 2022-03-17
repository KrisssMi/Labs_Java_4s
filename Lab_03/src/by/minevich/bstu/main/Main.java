package by.minevich.bstu.main;

import java.io.File;
import java.util.Scanner;
import by.minevich.bstu.company.Director;
import by.minevich.bstu.team.Admin;
import by.minevich.bstu.team.Programmer;
import by.minevich.bstu.exceptions.AddException;
import by.minevich.bstu.company.Company;
import by.minevich.bstu.human.Human;
import by.minevich.bstu.level.Level;
import by.minevich.bstu.parser.Sax;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.xml.sax.SAXException;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.stream.Stream;

public class Main {
    static {
        new DOMConfigurator().doConfigure("E:/JAVA/Lab_03/log/log4j.xml", LogManager.getLoggerRepository());
    }

    private static final Logger LOG = Logger.getLogger(Main.class);

    public static void main(String[] args) {

        //TODO Лабораторная работа №3:

        try {
            LOG.info("Начало программы.");

            Company company = new Company("EPAM");
            company.add(new Programmer("Алексей", 24, Level.Middle, 1200.8f));
            company.add(new Programmer("Елена", 19, Level.Junior, 650.2f));
            company.add(new Programmer("Михаил", 25, Level.Senior, 1020.6f));

            Programmer pr1= new Programmer("Эмилия", 28, Level.Middle, 1200.9f);
            Programmer pr2=new Programmer("Каролина", 23, Level.Senior, 1420.8f);

            company.add(new Admin("Георгий", 30, 1600.3f));

            LOG.info("Набор в компанию выполнен.");
            company.show();

            Director.count(company);
            System.out.println("\t\t\tSenior >");
            Director.find(company, Level.Senior);
            LOG.info("Поиск совершён.");

            System.out.println("\t\tСортировка: ");
            Director.sort(company);
            company.show();
            LOG.info("Список отсортирован.");

            Admin admin = new Admin("Ксения", 34, 1222.2f);
            Admin admin2 = new Admin("Даниил", 29, 1590.1f);


            //TODO Лабораторная работа №4
            //1
            System.out.println("\t\t\tСериализация в XML > ");
            FileOutputStream xmlOut = new FileOutputStream("E:/JAVA/Lab_03/files/info.xml");
            XMLEncoder xmlEncoder = new XMLEncoder(xmlOut);
            xmlEncoder.writeObject(admin);
            xmlEncoder.close();
            LOG.info("XML сериализован.");
            //2
            System.out.println("\t\t\tДесериализация из XML > ");
            FileInputStream xmlIn = new FileInputStream("E:/JAVA/Lab_03/files/info.xml");
            XMLDecoder xmlDecoder = new XMLDecoder(xmlIn);
            Admin annaXML = (Admin)xmlDecoder.readObject();
            xmlDecoder.close();
            annaXML.show();
            LOG.info("XML десериализован.");
            //3
            System.out.println("\t\t\tСериализация в JSON > ");
            Gson gson = new GsonBuilder().create();
            String json = gson.toJson(admin);
            System.out.println(json);
            FileOutputStream jsonOut = new FileOutputStream("E:/JAVA/Lab_03/files/info.json");
            byte[] outText = json.getBytes(StandardCharsets.UTF_8);
            jsonOut.write(outText, 0, outText.length);
            LOG.info("JSON сериализован.");
            //4
            System.out.println("\t\t\tДесериализация в JSON > ");
            Scanner scanner = new Scanner(new File("E:/JAVA/Lab_03/files/info.json"));
            StringBuilder result = new StringBuilder();
            while(scanner.hasNext())
                result.append(scanner.nextLine());
            scanner.close();
            Admin annaJson = gson.fromJson(result.toString(), Admin.class);
            annaJson.show();
            LOG.info("JSON десериализован.");
            //5
            System.out.println("\t\t\tStream API (обработка данных в функциональном стиле) >");
            Stream<Human> resStream = company.getList().stream().filter(s -> s.getSalary() > 800);
            for(var i : resStream.toList()) {
                i.show();
            }
            LOG.info("Stream API.");
            //6
            System.out.println("\t\t\tSAX-парсер >");
            SAXParserFactory factory = SAXParserFactory.newInstance();
            SAXParser parser = factory.newSAXParser();
            Sax sax = new Sax();
            parser.parse(new File("E:/JAVA/Lab_03/files/Admin.xml"), sax);
            Admin alex = sax.getResult();
            alex.show();
            LOG.info("SAX.");
        }
        catch (AddException ex) {
            LOG.info(ex.getMessage() + " (" + ex.number + ")");
        } catch (IOException | ParserConfigurationException | SAXException e) {
            e.printStackTrace();
        } finally {
            LOG.info("Финальный блок (выполняется в любом случае).\n");
        }
    }
}
