package main;
import static java.time.temporal.ChronoUnit.MILLIS;
import lombok.extern.slf4j.Slf4j;
import patterns.abstractFactory.CardType;
import patterns.abstractFactory.CreditCard;
import patterns.abstractFactory.CreditCardAbstractFactory;
import patterns.builder.LunchOrder;
import patterns.factory.SiteType;
import patterns.factory.Webside;
import patterns.factory.WebsideFactory;
import patterns.prototype.Movie;
import patterns.prototype.Registry;
import patterns.singleton.DBLazySingleton;
import patterns.singleton.DBSingleton;

import java.io.*;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalTime;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by Arkadiusz.Ptak on 04.12.2017.
 */
@Slf4j
public class Main {




    public static void main(String args[]) throws IOException, ClassNotFoundException, ExecutionException, InterruptedException, TimeoutException {
       // singletonDemo();
      //  lazySingletonDemo();
       // connectToDB();
    //lambda();
       // printer.accept("lambda");
      //  prototype();
//        abstractFactory();
//        Z z = new Z();
//        z.updateA(null);
//        String pusty= null;
//        pusty=null;
//        System.out.print(pusty);
//        String s ="s";
//        System.out.print(s);
//        s=s(s);
//        System.out.print(s);
//        stream();
//        sortowanie();
//
//        Nowa n = new Nowa(1,2);
//        Nowa m = new Nowa(3,4);
//        List<Nowa> lista = Arrays.asList(n,m);
//        Set<Integer> set = new HashSet<>();
//        log.info("rozmiar mapy{}", set.size());
//         Map<Integer, Object> mapa = new HashMap<>();
//         mapa.put(1, new Integer(1));
//        mapa.keySet();
//        Set<Integer> sets = new HashSet<>(mapa.keySet());
//        log.info("mapa rozmiar: {}", sets.size());
       // metoda1111();
       // porownanie();
       // createFile();
      //  log.info("{}",proba());
      //  breakTest();
      //  dekorator();
       // System.out.print(lista.get(1));
       // timeCompare();
      //  testInstancji();
        //spacjaWStringu();
       // log.info("return  ... {}", futureTaski());
      //  Thread.sleep(2000);
     //   log.info("Poszlo: {}", LocalTime.now());
      //  log.info(testObject("22"));
       // testString();
       // cemTest();
        //testSet();
       // testEqualsInteger();
        //OptionalTest.run();
        testUniqueNames();
        //flatMapTest();
    }

    public static String[] uniqueNames(String[] names1, String[] names2) {
        String[] s =  Stream.of(names1,names2).flatMap(Stream::of).distinct().toArray(String[]::new);
    Arrays.stream(s).count();
        return s;
    }
    public static void testUniqueNames(){
        String[] names1 = new String[] {"Ava", "Emma", "Olivia"};
        String[] names2 = new String[] {"Olivia", "Sophia", "Emma"};


        System.out.println(String.join(", ", uniqueNames(names1, names2))); // sho
    }

    private static void flatMapTest(){
        String[][] data = new String[][]{{"a", "b"}, {"c", "d"}, {"e", "f"}};
        log.info(data[0][0]);
        log.info(data[0][1]);
        log.info(data[1][0]);
        log.info(data[1][1]);
        log.info(data[2][0]);
        log.info(data[2][1]);
        Stream.of(data).forEach(s-> log.info(s[1]));
       String[] s= Stream.of(data).flatMap(Stream::of).toArray(String[]::new);
       Stream.of(s).forEach(log::info);
       ////////////////////////////
        Student obj1 = new Student();
        obj1.setName("mkyong");
        obj1.addBook("Java 8 in Action");
        obj1.addBook("Spring Boot in Action");
        obj1.addBook("Effective Java (2nd Edition)");

        Student obj2 = new Student();
        obj2.setName("zilap");
        obj2.addBook("Learning Python, 5th Edition");
        obj2.addBook("Effective Java (2nd Edition)");

        List<Student> list = new ArrayList<>();
        list.add(obj1);
        list.add(obj2);

        List<String> collect =
                list.stream()
                        .map(z -> z.getBook())
                        .flatMap(x -> x.stream())   //Stream<String>
                        .distinct()
                        .collect(Collectors.toList());

        collect.forEach(x -> System.out.println(x));
        List<String> listToFilter = Arrays.asList("a","b","c");
        listToFilter.stream().filter(m->!m.equals("b")).forEach(System.out::println);
        listToFilter.stream().filter(m->m.equals("b")).findAny().ifPresent(System.out::println);



    }
    public static int countNumbers(int[] sortedArray, int lessThan) {
        return  (int) Arrays.stream(sortedArray).filter(x-> x<lessThan).count();
    }

    private static void spacjaWStringu(){
        String statystyki ="pierwsza \n druga";
        log.info("statystyki: {}",statystyki);
        List<Integer> wagons = new LinkedList<>();
        wagons.add(0,22);

    }

    private static void testInstancji(){
        A instancjaA= zwrocA();
        ImplementA instacjaImplementA = (ImplementA) instancjaA;
        instacjaImplementA.doatkowaMetoda();
        A instancjaA2= zwrocA2();
        ImplementA2 instacjaImplementA2 = (ImplementA2) instancjaA2;
        instacjaImplementA2.doatkowaMetoda();

        A instancjaExtendsA = new ImplementsExtendsA();

        if(instancjaExtendsA instanceof A){
            log.info("instancjaExtendsA jest A");
        }

        if(instancjaExtendsA instanceof ImplementsExtendsA){
            log.info("instancjaExtendsA jest ImplementsExtendsA");
        }

        if(instancjaExtendsA instanceof ExtendsA){
            log.info("instancjaExtendsA jest ExtendsA");
        }

        if(instacjaImplementA2 instanceof A){
            log.info("jest A");
        }
        if(instacjaImplementA2 instanceof ImplementA2){
            log.info("jest ImplementA2");
        }
    }
    private static void metoda1111(){
        metoda222(1);
        log.info("po 1");
        metoda222(2);
        log.info("po 2");
    }

    private static void printInt(int i){
        System.out.println("INTEGER: " + i);
    }
    private static void metoda222(int i){
        log.info("weszlo do metoda222");
        if(i ==2 ) {

            return;
        }

    }

   static class Nowa{
        int a;
        int b;

        Nowa(int a, int b){
            this.a=a;
            this.b=b;
        }
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
        log.info("LOG::");
 lista.stream().forEach(log::info);
        log.info("LOG::KONIEC");
        lista.stream().filter(value->!value.equals("2")).forEach(value->log.info("druga: "+value));
        List nowa = lista.stream().map(value->value.toUpperCase()).collect(Collectors.toList());
        nowa.forEach(value->log.info("trzecia3 : "+value));
    }

    private static void sortowanie(){
        List<String> przedSortowaniem = Arrays.asList("b","a","2","f","z","c","1");
        String[] animals = {"cat", "dog", "mouse", "rat", "pig", "rabbit", "hamster", "parrot"};

        /**
         omparator<String> sortByName =(String s1, String s2) -> (s1.compareTo(s2));

         równa się to:

         Comparator<String> s = new Comparator<String>() {
        @Override
        public int compare(String s1, String s2) {
        return s1.compareTo(s2);
        }
        };
         */
        Map<String,Integer> map = new HashMap<>();
        map.put("1",2);

        map.forEach((k,v)->log.info(k));

        Comparator<String> sortByName =(String s1, String s2) -> (s1.compareTo(s2));
        List<String> poSortowaniu = przedSortowaniem.stream().sorted(sortByName).collect(Collectors.toList());
        poSortowaniu.stream().forEach(c->log.info("posortowana: "+c));
        String s1= null;
        String s2="s";
        int i1 =1;
        Optional op = Optional.ofNullable(i1);
       Optional.ofNullable(s2).ifPresent(System.out::println);

        System.out.print(op.get());
    }

    private static void factory(){
        Webside webside = WebsideFactory.getWebside(SiteType.BLOG);

        log.info(String.valueOf(webside.getPages()));

    }

    private static void abstractFactory(){
        CreditCardAbstractFactory abstractFactory = CreditCardAbstractFactory.getCreditCardFactory(651);
        CreditCard creditCard = abstractFactory.getCreditCard(CardType.GOLD);
        log.info(String.valueOf(creditCard.getClass()));

        abstractFactory = CreditCardAbstractFactory.getCreditCardFactory(200);
        creditCard = abstractFactory.getCreditCard(CardType.PLATINUM);
        log.info(String.valueOf(creditCard.getClass()));
    }

    private static void porownanie(){
/*        String s ="s";
        String d = new String("s");
        int jeden =1;
        int zero=1;
        int zero1=1;

        Integer one = new Integer(1);
        Integer one1 = new Integer(1);

        System.out.println(s==d);//false
        System.out.println(s.equals(d));//true
        System.out.println(jeden == zero);//true
        System.out.println(one.equals(jeden));//true
        System.out.println(one.equals(one1));//true
        System.out.println(one == zero1);//true
        System.out.println(one == one1);//false
        System.out.println(one == one);//true
        System.out.println(one.equals(one));//true*/



    }

    private static boolean proba(){
        try {

            return true;

        }catch(Exception e){

        }
        finally{
            return false;
        }

    }

    private static void createFile() throws IOException {
        File file = new File("C:\\Users\\arkadiusz.ptak\\InteliJ\\Plural\\Plik.txt");
        FileWriter w = new FileWriter(file);
        w.write("s");
        w.close();
        String line = null;
        FileReader r = new FileReader(file);
        BufferedReader bufferedReader =
                new BufferedReader(r);

        while((line = bufferedReader.readLine()) != null) {
            System.out.println(line);
        }

        System.out.print(System.getProperty("user.dir"));
    }

    private static void  breakTest() {
        boolean test = true;
        outerLoop:
        for (int j = 0; j < 30; j++) {
            System.out.println("jot " + j);
            for (int i = 0; i < 10; i++) {
                System.out.println("test " + i);
                if (i == 3) {
                    test = false;
                }
                if (!test) {
                    break outerLoop;
                }
            }
        }
    }

    private static void dekorator() throws ClassNotFoundException {
        KlasaD d = new KlasaD();
        d.removeInnerDecorator((Class<? extends RozszerzającaKlasa>) Class.forName("main.KlasaDECORATORSEND"));
    }

    private static void timeCompare(){
        LocalTime now = LocalTime.now();

        log.info("ROZNICA: {}",MILLIS.between(now, now.plusSeconds(20)) );
    }

    private static A zwrocA(){
        return new ImplementA();
    }

    private static A zwrocA2(){
        return new ImplementA2();
    }

    private static synchronized void watki(){
        log.info("watek wystartowal: {}", LocalTime.now());
        try {
            log.info("watek usypiany: {}", LocalTime.now());
            Thread.sleep(10*1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        log.info("Watek wystartowal ponownie: {}", LocalTime.now());

    }
    private static String futureTaski() throws InterruptedException, ExecutionException, TimeoutException {
         final ExecutorService threadpool = Executors.newCachedThreadPool();
        FutureCall task = new FutureCall();
        log.info("Submitting Task ...");


         threadpool.submit(task);
         try {
             Thread.sleep(2000);
         }catch (InterruptedException e){
             log.info("przerwalo1: {}", task.getWynik()); ;
             Thread.currentThread().interrupt();
             log.info("przerwalo2: {}", task.getWynik()); ;
             threadpool.shutdown();
             return "PRZERWALO";
         }
       // log.info("WYNIK Z FUTURE: {}", future.get(2, TimeUnit.SECONDS));
       // log.info("Wynik Ostateczny: {}", task.getWynik()); ;
       // Thread.sleep(2000);
    /*    while (!future.isDone()) {
            log.info("Task is not completed yet....");
            Thread.sleep(1); //sleep for 1 millisecond before checking again
        }*/


      //  threadpool.shutdown();
       return"KONIEC";
    }

    private static String testObject(Object input){
        String s ="";
        String puste = null;
        if (puste == null){
            log.info("HASLO PUSTE !!!");
        }
        if(s.isEmpty()){
            log.info("{} string was empty!", s);
        }

        return input.toString();
    }

    private static void cemTest(){
        int pay =230;
        int cost =0;
        int TAX_PERCENT_VALUE =18;
        int tax = TAX_PERCENT_VALUE*(pay - cost)/100;


            cost = 50*pay/100;

            //cost = 20*pay/100;


        log.info("TAX: {}", tax);

     /*   log.info("COST: {}", cost);
        tax = (tax/100+1)*100;*/
        log.info("TAX1: {}", tax);
        tax = (tax/100)*100;
        log.info("TAX2: {}", tax);
       /* if (tax%100>=50){
            tax = (tax/100+1)*100;
            log.info("TAX1: {}", tax);
        } else {
            tax = (tax/100)*100;
            log.info("TAX2: {}", tax);
        }*/
        int suma = pay - tax;
        log.info("WYSZLO: {}", suma);
    }
    private static void testString(){

        switch(1){
            case 1:
                log.info("1");
                break;

            case 2:
                log.info("2");
                break;
                default:
                    log.info("def");
                    break;
        }

        String puste="";
        String puste1="";
        String puste2 =new String("");
        if (puste1 == puste){
            log.info("RÓWNE dla ==!!!");
        }

        if (puste1.equals( puste)){
            log.info("RÓWNE dla equals !!!");
        }

        if (puste1.equals( puste2)){
            log.info("RÓWNE dla equals i new !!!");
        }

        if (puste1 == puste2){
            log.info("RÓWNE dla == i new !!!");
        }
    }

    private static void testEqualsInteger(){
        Integer integer = 1029;
        Integer iNew =  new Integer(1029);
        Integer iNew2 =  new Integer(1029);
        String s1 = new String("tosamo");
        String s2 = new String("tosamo");
        int i = 1029;
        Integer integer2 = 128;

        if(integer == iNew){
            log.info("Integer integer = 1029 == Integer iNew =  new Integer(1029)");
        }

        if(integer.equals( iNew)){
            log.info("Integer integer = 1029 .EQUALS Integer iNew =  new Integer(1029)");
        }
        if(integer == 1029){
            log.info("Integer integer = 1029 == 1029");
        }

        if(integer == i){
            log.info("Integer integer = 1029 ==  int i = 1029;");
        }

        if(integer == integer2){
            log.info("Integer integer = 1029 ==  Integer integer2 = 1029;");
        }

        if(iNew == 1029){
            log.info("Integer iNew =  new Integer(1029); == 1029");
        }

        if(iNew.equals( 1029)){
            log.info("Integer iNew =  new Integer(1029); .EQUALS 1029");
        }

        if(iNew == i){
            log.info("Integer iNew =  new Integer(1029); ==  int i = 1029;");
        }

        if(iNew == iNew2){
            log.info("Integer iNew =  new Integer(1029); ==    Integer iNew2 =  new Integer(1029);");
        }
        if('a' == 97){
            log.info("a has 97 value in ascii code");
        }

        if(s1 == s2){
            log.info(" String s1 = new String(\"tosamo\");\n" +
                    "        String s2 = new String(\"tosamo\");");
        }

    }

    private static void testSet(){
        Set<WithEquals> testSet = new HashSet();
        WithEquals first = new WithEquals("a", "b", 1);
        WithEquals second = new WithEquals("a", "b", 1);
        testSet.add(first);
        testSet.add(second);
        testSet.stream().forEach(we->log.info(we.a));
    }



}
