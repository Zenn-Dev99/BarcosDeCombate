# ⚓ BarcosDeGuerra CRUD (Java Console App)

Sistema de gestión de barcos de guerra desarrollado en Java, con enfoque educativo para aplicar patrones de diseño del paradigma orientado a objetos. Esta aplicación permite agregar, clonar, eliminar, listar y filtrar barcos desde consola, utilizando estructuras internas y patrones conocidos.

---

#### 📌 Descripción del sistema y problema a resolver

La gestión de barcos de guerra puede volverse compleja cuando se requiere mantener un catálogo centralizado, organizar diferentes tipos (portaaviones, destructores, submarinos), reutilizar diseños y filtrar eficientemente. Este sistema resuelve ese problema con una aplicación por consola simple, eficaz y orientada a buenas prácticas de diseño.

---

#### 🧩 Patrones de diseño implementados

##### 1. Singleton
- **Clase:** `BarcoService`
- **Por qué:** Se necesita una única instancia que controle la lista de barcos y actúe como “núcleo” del sistema.
- **Dónde:** Todos los métodos CRUD interactúan con `BarcoService.getInstancia()` para asegurar consistencia global.

##### 2. Prototype
- **Clase:** `Barco` (implementa `Cloneable`)
- **Por qué:** Permite crear rápidamente copias de barcos existentes para simular producción en masa o modificaciones leves.
- **Dónde:** El menú de consola permite clonar barcos, duplicando su información con nuevo ID y nombre ajustado.

##### 3. Iterator
- **Clases:** `BarcoIterator` (interfaz), `TipoBarcoIterator`
- **Por qué:** Facilita recorrer barcos filtrando por tipo sin exponer la lista completa ni mezclar lógica de búsqueda.
- **Dónde:** Opción del menú que muestra barcos por tipo (“Submarino”, “Destructor”, etc.) usando el iterador específico.

##### 4. Adapter
- **Clases:** `BarcoExterno`, `BarcoAdapter`
- **Por qué:** Simula la integración de datos provenientes de fuentes incompatibles (por ejemplo, archivos externos o APIs).
- **Dónde:** El sistema puede importar un objeto `BarcoImportado` y adaptarlo al formato estándar `Barco`.

---

#### 🧪 Instrucciones de compilación y ejecución

##### Requisitos
- Java 11 o superior
- Editor o IDE Java (opcional): Eclipse, IntelliJ, VS Code, etc.

##### Compilar desde terminal
```bash
javac model/*.java
java model.main

#### Estructura del Proyecto
model/
├── Barco.java
├── BarcoService.java
├── MainApp.java
├── BarcoIterator.java
├── TipoBarcoIterator.java
├── BarcoExterno.java
├── BarcoAdapter.java
├── BarcoImportado.java
