package libs;

import org.aeonbits.owner.Config;

public interface ConfigProperties extends Config {  //интерфейс , описывает то что мы хотим получить с Properties
	long TIME_FOR_DFFAULT_WAIT();
	long TIME_FOR_EXPLICIT_WAIT_LOW();
	long TIME_FOR_EXPLICIT_WAIT_HIGHT();

	String base_url();
	String DATA_FILE();
	String DATA_FILE_SUITE();
	String Oracle();
	String MySQL();
	String sqlServer();

	String MySQL_DB();
	String MySQL_DB_USER();
	String MySQL_DB_PASSWORD();
}
