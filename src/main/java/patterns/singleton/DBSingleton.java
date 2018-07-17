package patterns.singleton;

/**
 * Singleton class
 *
 * uzywany gdy jedna instancja jest tworzona,
 * gwarantuje kontrole nad resourcem
 *
 * Nie ma interfejsu
 *
 * cieżko je unit testowac
 * moga byc not thread-safe
 */
public class DBSingleton {
    private static DBSingleton instance = new DBSingleton();

    private DBSingleton(){

    }
    public static DBSingleton getInstance(){
        return instance;
    }

}
