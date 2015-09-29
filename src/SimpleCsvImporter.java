import net.sf.jabref.logic.id.*;
import net.sf.jabref.importer.fileformat.*;
import net.sf.jabref.importer.*;

import java.lang.Override;
import java.util.*;
import java.io.*;
import net.sf.jabref.model.entry.*;

public class SimpleCsvImporter extends ImportFormat {

    @Override
    public String getFormatName() {
        return "Simple CSV Importer";
    }

    @Override
    public boolean isRecognizedFormat(InputStream stream) throws IOException {
        return true; // this is discouraged except for demonstration purposes
    }

    @Override
    public List<BibtexEntry> importEntries(InputStream stream, OutputPrinter status) throws IOException {
        List<BibtexEntry> bibitems = new ArrayList<BibtexEntry>();

        BufferedReader in = new BufferedReader(ImportFormatReader.getReaderDefaultEncoding(stream));

        String line = in.readLine();
        while (line != null) {
            if (!"".equals(line.trim())) {
                String[] fields = line.split(";");
                BibtexEntry be = new BibtexEntry(IdGenerator.next());
                be.setType(BibtexEntryType.getType("techreport"));
                be.setField("year", fields[0]);
                be.setField("author", fields[1]);
                be.setField("title", fields[2]);
                bibitems.add(be);
                line = in.readLine();
            }
        }

        return bibitems;
    }

    @Override
    public String getExtensions() {
        return "csv";
    }

}
