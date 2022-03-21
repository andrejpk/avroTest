import org.apache.avro.file.DataFileReader
import org.apache.avro.generic.GenericDatumReader
import org.apache.avro.generic.GenericRecord
import java.io.File

    fun ReadFile(filename: String) {

        System.out.println("Loading file $filename")
        val datumReader = GenericDatumReader<GenericRecord>()
        val dataFileReader = DataFileReader(File(filename), datumReader)

        var message: GenericRecord? = null
        var line = 0
        while (dataFileReader.hasNext()) {

            message = dataFileReader.next(message)
            System.out.println("Loading line $line")
            System.out.println(message)
            line++
        }

    }