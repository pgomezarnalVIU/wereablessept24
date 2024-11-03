import "package:flutter/material.dart";
import "package:mis_imagenes/data/sp_helper.dart";
import "package:mis_imagenes/screens/quote_screen.dart";
import "package:mis_imagenes/screens/settings_screen.dart";

class IntroScreen extends StatefulWidget {
  const IntroScreen({super.key});

  @override
  State<IntroScreen> createState() => _IntroScreenState();
}

class _IntroScreenState extends State<IntroScreen> {
  String name = '';
  String image = 'Lake';
  final SPHelper helper = SPHelper();

  @override
  void initState() {
    super.initState();
    getSettings();
  }

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      body: Stack(
        children: [
          Positioned.fill(
              child: Image.asset(
            'assets/$image.jpg',
            fit: BoxFit.cover,
          )),
          Align(
              alignment: const Alignment(0, -0.5),
              child: Text(
                'Bienvenido $name',
                style: const TextStyle(
                    color: Colors.white,
                    shadows: [
                      Shadow(
                          blurRadius: 10,
                          color: Colors.black,
                          offset: Offset(5, 5))
                    ],
                    fontSize: 24),
              )),
          Align(
            alignment: const Alignment(0, 0.5),
            child: ElevatedButton(
                onPressed: () {
                  Navigator.of(context).pushReplacement(MaterialPageRoute(
                      builder: (BuildContext contenxt) => const QuoteScreen()));
                },
                child: const Text('EMPEZAR')),
          )
        ],
      ),
    );
  }

  Future<void> getSettings() async {
    Map<String, String> settings = await helper.getSettings();
    image = settings['image'] ?? 'Lake';
    name = settings['name'] ?? '';
    image = (image == "") ? 'Lake' : image;
    name = (name == "") ? 'Desconocido' : name;
    setState(() {});
  }
}
