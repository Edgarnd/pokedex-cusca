# PokedexCusca

**Autor:** Edgardo Renderos

## Descripción del Proyecto
Pokemon Cusca es una aplicación Android desarrollada en **Jetpack Compose** que permite explorar y consultar información de Pokemon. La app consume la [PokéAPI](https://pokeapi.co/) para mostrar listas de Pokemon, detalles individuales, estadísticas, tipos, imágenes y descripciones.

La interfaz está completamente construida con **Jetpack Compose**, ofreciendo un diseño moderno y responsivo, compatible con **modo claro y oscuro**.

## Tecnologías y Herramientas

- **Lenguaje:** Kotlin
- **Arquitectura:** MVVM
- **Inyección de Dependencias:** Hilt
- **IDE:** Android Studio Meerkat (versión específica utilizada: 2024.3.2)
- **AGP:** 8.10.1
- **JDK:** OpenJDK 17
- **API:** OpenAPI / RESTful API con PokéAPI
- **Gestión de imágenes:** Coil para cargar sprites de Pokemon y GIFs
- **Navegación:** Jetpack Navigation Compose
- **Persistencia:** MutableState / StateFlow (para manejo de estado en ViewModels)
- **Compatibilidad:** Android 7.0 (API 24) en adelante

## Características

- Lista paginada de Pokemon con **búsqueda por nombre**.
- Detalle de cada Pokemon mostrando:
  - Imagen principal
  - Tipos con colores e iconos representativos
  - Estadísticas en barras horizontales con colores dinámicos
  - Peso y altura en una card estilizada
  - Descripción de cada pokemon
- Temas claros y oscuros adaptativos.
- Animaciones de carga usando GIFs en diálogos.
- Interfaz totalmente **composable**, modularizada por componentes reutilizables.

## Arquitectura del Proyecto

- `core-model`: Contiene los DTO que se utilizan para toda la aplicacion movil.
- `core-network`: Utiliza las librerías de HTTP para llamados a servicios **Restful**.
- `core-repository`: Realiza los llamados a **API**, **parametrización** y configuraciones de **paginacion**.
- `core-ui`: Posee los **temas**, **tipografías**, **colores**, **componentes reutilizables** y **dialogs**.
- `pokemon-list`: Pantalla principal con lista de Pokemons y buscador.
- `pokemon-detail`: Pantalla de detalle de pokemon con imagen, tipos, estadisticas y fisico.

## Requisitos de Desarrollo

- Android Studio Meerkat con JDK 17
- Conexión a Internet para consumir la API de Pokemon
- Hilt configurado para inyección de dependencias
- Kotlin >= 1.9

## Probar

1. Clonar el repositorio:
```bash
git clone https://github.com/Edgarnd/pokedex-cusca.git
