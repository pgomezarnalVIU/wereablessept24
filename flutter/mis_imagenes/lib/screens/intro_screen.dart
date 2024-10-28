import "package:flutter/material.dart";
import "package:mis_imagenes/screens/settings_screen.dart";

class IntroScreen extends StatelessWidget {
  const IntroScreen({super.key});

  @override
  Widget build(BuildContext context) {
    return Scaffold(
        appBar: AppBar(title: const Text("Primera pantalla")),
        body: Stack(
          children: [
            Positioned.fill(
              child: Image.asset(
                'assets/Lake.jpg',
                fit: BoxFit.cover,
              ),
            ),
            const Align(
                alignment: Alignment(0, -0.5),
                child: Text('Mi primera pantalla',
                    style: TextStyle(fontSize: 24, color: Colors.white))),
            Align(
                alignment: const Alignment(0, 0.5),
                child: ElevatedButton(
                    onPressed: () {
                      Navigator.of(context).push(MaterialPageRoute(
                          builder: (BuildContext builder) =>
                              const SettingsScreen()));
                    },
                    child: const Text("EMPEZAR"))),
          ],
        ));
  }
}
