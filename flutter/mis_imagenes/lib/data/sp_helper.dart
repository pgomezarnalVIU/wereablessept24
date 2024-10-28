import 'package:shared_preferences/shared_preferences.dart';

//Clase que permite manejar datos compartidos para las imagenes
class SPHelper {
  //Propiedades de la clase
  static const keyName = 'name';
  static const keyImage = 'image';

  //Función que permite lanzar consultas asincronas
  //Funcion que coloca en Shared Preferences dos Strings a la vez
  Future<bool> setSettings(String name, String image) async {
    //Instancia de SharedPreferences
    //Puede dar error, envolvemos con try/Exception
    try {
      final SharedPreferences prefs = await SharedPreferences.getInstance();
      await prefs.setString(keyName, name);
      await prefs.setString(keyImage, image);
      return true;
    } on Exception catch (e) {
      return false;
    }
  }

  //Funcion que devuelve las dos preferencias
  Future<Map<String, String>> getSettings() async {
    try {
      final SharedPreferences prefs = await SharedPreferences.getInstance();
      final String name = prefs.getString(keyName) ?? '';
      final String image = prefs.getString(keyImage) ?? '';
      return {keyName: name, keyImage: image};
    } on Exception catch (e) {
      return {};
    }
  }
}
