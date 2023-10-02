import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/medicines")
public class MedicineController {
    private  Map<Integer, Medicine> medicineDatabase = new HashMap<>();
    private int nextMedicineId = 1;

    // Add a new Medicine
    @PostMapping
    public boolean addMedicine(@RequestBody Medicine medicine) {
        medicine.setMedicineId(nextMedicineId++);
        medicineDatabase.put(medicine.getMedicineId(), medicine);
        return true;
    }

    // Update an existing Medicine
    @PutMapping("/{medicineId}")
    public Medicine updateMedicine(@PathVariable int medicineId, @RequestBody Medicine updatedMedicine) {
        Medicine existingMedicine = medicineDatabase.get(medicineId);
        if (existingMedicine != null) {
            // Update the fields with the new values
            existingMedicine.setMedicineName(updatedMedicine.getMedicineName());
            existingMedicine.setPrice(updatedMedicine.getPrice());
            existingMedicine.setDescription(updatedMedicine.getDescription());
            existingMedicine.setQuantity(updatedMedicine.getQuantity());

            return existingMedicine;
        }
        return null; // Medicine not found
    }
}