# Comparison of XML Parsers: DOM, SAX, and StAX

| Feature                      | DOM (Document Object Model)               | SAX (Simple API for XML)                | StAX (Streaming API for XML)            |
|------------------------------|-------------------------------------------|-----------------------------------------|-----------------------------------------|
| **Parsing Model**            | Tree-based (loads entire document)        | Event-based                             | Pull-based (streaming)                  |
| **Memory Usage**             | High (entire document loaded in memory)   | Low (reads data sequentially)           | Low (reads data sequentially)           |
| **Access Type**              | Random access (entire tree in memory)     | Sequential (cannot move backward)       | Sequential (pull events as needed)      |
| **Ease of Use**              | Simple for small documents, full control  | Requires handler for events             | More control than SAX, less complex     |
| **Suitable for Large Files** | No, due to high memory consumption        | Yes, due to low memory usage            | Yes, due to low memory usage            |
| **API Type**                 | In-memory representation                  | Event-driven (push API)                 | Pull-based (pull API)                   |
| **Modification of XML**      | Yes (supports modifying the document)     | No (read-only)                          | Yes (read-write API available)          |
| **When to Use**              | When random access is needed, small files | When memory is constrained, large files | When streaming, control, and efficiency |
| **Example Use Case**         | Configuration files, small documents      | Processing large XML logs or streams    | Processing web services, large files    |



# Author
Aarfi Siddique