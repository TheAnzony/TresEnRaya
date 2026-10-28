# ❌⭕ Tres en Raya

Juego clásico del tres en raya para Android, para **dos jugadores en el mismo dispositivo**, desarrollado en **Kotlin** como práctica del ciclo de **Desarrollo de Aplicaciones Multiplataforma (DAM)**.

Los jugadores colocan por turnos **X** y **O** en un tablero de 3×3. Gana el primero que consiga tres fichas en línea: en horizontal, en vertical o en diagonal.

## 🕹️ Cómo se juega

1. Empieza siempre el jugador **X**.
2. Pulsa una casilla vacía para colocar tu ficha; el turno pasa al otro jugador.
3. En la parte superior se indica de quién es el turno.
4. La partida termina cuando:
   - un jugador consigue **tres en raya** → se muestra el ganador, o
   - se llenan las 9 casillas sin ganador → **empate**.
5. Pulsa **Reset** para empezar una nueva partida.

## ✨ Características

- Modo de dos jugadores por turnos.
- Detección de victoria en filas, columnas y diagonales, y detección de empate.
- Cada ficha con su propio color para distinguir X y O de un vistazo.
- Las casillas ocupadas no se pueden volver a pulsar, y el tablero se bloquea al terminar la partida.
- **Conserva la partida al girar el móvil**: el estado del tablero y del juego se guarda con `onSaveInstanceState` y se recupera con `onRestoreInstanceState`.
- Interfaz adaptable con **ConstraintLayout** y *guidelines* en porcentaje.
- Textos en `strings.xml` y colores en `colors.xml`.

## 🛠️ Tecnologías

| | |
|---|---|
| Lenguaje | Kotlin |
| IDE | Android Studio |
| Layout | XML + ConstraintLayout (guidelines) |
| Activity | `AppCompatActivity` |
| Botones | `AppCompatButton` |
| Acceso a vistas | View Binding |
| SDK mínimo | Android 7.0 (API 24) |
| SDK objetivo | API 37 |

## 📁 Estructura principal

```
app/src/main/
├── java/com/example/tresenraya/
│   └── MainActivity.kt          # Lógica del juego y guardado del estado
└── res/
    ├── layout/
    │   └── activity_main.xml    # Tablero 3×3, texto de turno y botón Reset
    └── values/
        ├── strings.xml          # Textos de la app
        ├── colors.xml           # Colores de X y O
        └── themes.xml
```

## 🚀 Cómo ejecutarlo

1. Clona el repositorio:
   ```bash
   git clone https://github.com/TheAnzony/TresEnRaya.git
   ```
2. Ábrelo con **Android Studio** (*File → Open* y selecciona la carpeta del proyecto).
3. Espera a que termine la sincronización de Gradle.
4. Ejecútalo en un emulador o en un móvil con Android 7.0 o superior pulsando **Run ▶**.

## 👤 Autor

**TheAnzony** — [github.com/TheAnzony](https://github.com/TheAnzony)

Proyecto realizado con fines educativos.
