import model.Medicine;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/medicines")
public class MedicineController {
    private List<Medicine> pharmacySystem = new ArrayList<>();

    @PostMapping
    public boolean addMedicine(@RequestBody Medicine medicine) {
        // Implement logic to add medicine to the pharmacy system
        return pharmacySystem.add(medicine);
    }

    @PutMapping("/{medicineId}")
    public Medicine updateMedicine(@PathVariable int medicineId, @RequestBody Medicine updatedMedicine) {
        // Implement logic to update medicine with the given medicineId
        for (Medicine medicine : pharmacySystem) {
            if (medicine.getMedicineId() == medicineId) {
                // Update the existing medicine with updatedMedicine data
                medicine.setMedicineName(updatedMedicine.getMedicineName());
                medicine.setPrice(updatedMedicine.getPrice());
                medicine.setQuantity(updatedMedicine.getQuantity());
                medicine.setDescription(updatedMedicine.getDescription());
                return medicine; // Return the updated Medicine object
            }
        }
        return null; // Return null if no medicine with the given ID is found
    }
}