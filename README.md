# Sales Processing System - Final Project

This repository contains the complete development for the **Programming Fundamental Concepts** course. The system is designed to generate pseudo-random sales data and process it to create consolidated performance reports.

## 🚀 Key Features

### 1. Data Generation (`GenerateInfoFiles.java`)
* Creates `products_info.txt` with random IDs, names, and prices.
* Generates `salesmen_info.txt` with document types and names.
* Simulates individual sales files (`sales_ID.txt`) for each salesman.

### 2. Data Processing (`Main.java`)
* Reads all generated files and stores product prices in memory.
* Calculates total sales per salesman (Price * Quantity).
* Sorts salesmen by performance (highest sales first).
* Generates a final report: `final_report.txt`.

## 📂 Project Structure
* `src/`: Java source code (`GenerateInfoFiles.java` and `Main.java`).
* `data/`: Directory for input and output `.txt` files.
* `conclusion.txt`: Final project reflections and learnings.
* `.gitignore`: Configuration to keep the repository clean.

## 🛠️ Execution Instructions
1. Run `GenerateInfoFiles.java` to create the test database.
2. Run `Main.java` to process the data and generate the final report.
3. Check the results in `data/final_report.txt`.

---

# Sistema de Procesamiento de Ventas - Proyecto Final

Este repositorio contiene el desarrollo completo para la materia **Conceptos Fundamentales de Programación**. El sistema genera datos de ventas pseudoaleatorios y los procesa para crear reportes consolidados de rendimiento.

## 🚀 Funcionalidades Principales

### 1. Generación de Datos (`GenerateInfoFiles.java`)
* Crea `products_info.txt` con IDs, nombres y precios aleatorios.
* Genera `salesmen_info.txt` con tipos de documento y nombres.
* Simula archivos de ventas individuales (`sales_ID.txt`) por cada vendedor.

### 2. Procesamiento de Datos (`Main.java`)
* Lee todos los archivos generados y carga precios en memoria.
* Calcula el total de ventas por vendedor (Precio * Cantidad).
* Ordena a los vendedores por desempeño (mayor recaudo primero).
* Genera un reporte final: `final_report.txt`.

## 📂 Estructura del Proyecto
* `src/`: Código fuente (`GenerateInfoFiles.java` y `Main.java`).
* `data/`: Carpeta para archivos de entrada y salida.
* `conclusion.txt`: Resumen de aprendizajes y dificultades.

## 🛠️ Instrucciones de Ejecución
1. Ejecutar `GenerateInfoFiles.java` para crear la base de datos de prueba.
2. Ejecutar `Main.java` para procesar los datos y generar el reporte.
3. Verificar resultados en `data/final_report.txt`.

## 👤 Author / Autor
**Andrés Felipe Moreno Suárez** - Estudiante de Ingeniería de Software - Politécnico Grancolombiano.
