# JabRef Custom Importers

How to create, build and use a custom importer for [JabRef](https://github.com/jabref/jabref).

## Creating your custom importer

1. Create a class similar to `SimpleCsvImporter.java` that implements the abstract class `net.sf.jabref.importer.fileformat.ImportFormat`. 

Notes

- As you can reuse any class from JabRef be aware that changing the JabRef version the custom importer may break.
- Have a look at the documentation of `net.sf.jabref.importer.fileformat.ImportFormat` as it explains how to implement the methods.

## Building your custom importer

1. Copy `jabref.jar` into the `lib` folder.
2. Run `gradlew build`
3. The importer is now available as a jar in `build/libs`.

## Using your custom importer

1. Start JabRef with the exact same version as your previously copied `jabref.jar`.
2. Setup your custom importer through `Options --> Manage custom imports` by loading it from the jar and selecting your class that implements `ImportFormat`.
3. Import the file using `File --> Import into new database` or `File --> Import into current database`.