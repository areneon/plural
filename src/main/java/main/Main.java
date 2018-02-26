package main;

import lombok.extern.slf4j.Slf4j;
import patterns.builder.LunchOrder;
import patterns.prototype.Movie;
import patterns.prototype.Registry;
import patterns.singleton.DBLazySingleton;
import patterns.singleton.DBSingleton;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * Created by Arkadiusz.Ptak on 04.12.2017.
 */
@Slf4j
public class Main {
    public static void main(String args[]){
       // singletonDemo();
      //  lazySingletonDemo();
       // connectToDB();
    //lambda();
       // printer.accept("lambda");
      //  prototype();
        Z z = new Z();
        z.updateA(null);
        String pusty= null;
        pusty=null;
        System.out.print(pusty);
        String s ="s";
        System.out.print(s);
        s=s(s);
        System.out.print(s);
        stream();
    }

    private static String s(final String s){
        if(s.equals("s")){

            return s.replace("s","dupa");
        }
        return s;
    }
static class Z{
        String a;
        Z(){
          this.a=null;
        }
        public void updateA(String a){
            this.a=a;
        }
}
    private static void singletonDemo(){

        DBSingleton instance = DBSingleton.getInstance();
        System.out.println(instance);
        DBSingleton anotherInstance = DBSingleton.getInstance();
        System.out.println(anotherInstance);
        if(instance==anotherInstance){
            System.out.println("Are equals");

        }
    }
    private static void lazySingletonDemo(){

        DBLazySingleton instance = DBLazySingleton.getInstance();
        System.out.println(instance);
        DBLazySingleton anotherInstance = DBLazySingleton.getInstance();
        System.out.println(anotherInstance);
        if(instance==anotherInstance){
            System.out.println("Are equals");

        }
    }

    private static void connectToDB(){
        long timeBefore=0;
        long timeAfter=0;
        DBLazySingleton instance = DBLazySingleton.getInstance();

        timeBefore=System.currentTimeMillis();

        Connection con = instance.getConnection();
        timeAfter=System.currentTimeMillis();
        System.out.println("before: " +timeBefore +" after: "+ timeAfter + "difference: "+ (timeAfter - timeBefore));
        Statement statement;

        try{
            statement = con.createStatement();
            createAndFillTableAdress(statement);
        }
        catch(SQLException e ){
            e.printStackTrace();
        }
        timeBefore=System.currentTimeMillis();

       Connection con2 = instance.getConnection();
        timeAfter=System.currentTimeMillis();
        System.out.println("before2: " +timeBefore +" after2: "+ timeAfter + "difference2: "+ (timeAfter - timeBefore));

    }
    private static void createAndFillTableAdress(Statement statement){
        try {
            statement.executeUpdate("CREATE TABLE Adress(ID INT, StreetName VARCHAR(20), City VARCHAR(20))");
            System.out.println("Table Created!");
            statement.executeUpdate("INSERT INTO Adress values(1, 'sulejowska', 'Piotrkow')");
            ResultSet result = statement.executeQuery("SELECT * FROM Adress");
            while (result.next()) {
                System.out.println(result.getString("StreetName"));
            }
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static void builderDemo(){
        LunchOrder.Builder lunchBuilder = new LunchOrder.Builder("mandatory_parameter");
        lunchBuilder.dressing("dressing_parameter")
                .meat("mieso")
                .condiments("dodatki")
                .build();
        LunchOrder lunchOrder = new LunchOrder(lunchBuilder);
        System.out.println(lunchOrder);

    }

    private static void prototype(){
        Registry registry = new Registry();
        Movie movie = (Movie) registry.createItem("Movie");
        movie.setTitle("Creational Pattern in Java");

        System.out.println(movie);
        System.out.println(movie.getRuntime());
        System.out.println(movie.getTitle());
        System.out.println(movie.getUrl());

        Movie anotherMovie = (Movie) registry.createItem("Movie");
        anotherMovie.setTitle("Gang of four");

        System.out.println(anotherMovie);
        System.out.println(anotherMovie.getRuntime());
        System.out.println(anotherMovie.getTitle());
        System.out.println(anotherMovie.getUrl());

    }

    private static void lambda(){
       // Comparator<String> comparator = (String s1, String s2) -> Integer.compare(s1.length(),s2.length());
        Function<String,String> function1 = string->{string.concat("a");
            System.out.println(string);
            return string;};
    }
    static Consumer<String> printer = System.out::println;

    private static void stream(){
        List<String> lista = Arrays.asList("a", "b", "c", "d");
        List<String> lista2 = Arrays.asList("a", "b2", "c2", "d2");
        List<List<String>> polaczonaLista = Arrays.asList(lista,lista2);

        List<String> przefiltrowana = polaczonaLista.stream().flatMap(value->value.stream()).collect(Collectors.toList());
    lista.stream().filter(value->value.equals("2")).forEach(value->log.info("pierwsza: "+value));

        lista.stream().filter(value->!value.equals("2")).forEach(value->log.info("druga: "+value));
        List nowa = lista.stream().map(value->value.toUpperCase()).collect(Collectors.toList());
        nowa.forEach(value->log.info("trzecia: "+value));
    }
}