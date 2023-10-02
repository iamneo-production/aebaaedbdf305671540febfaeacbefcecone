import model.Medicine;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/medicines")
public class MedicineController {
    private List<Medicine> pharmacySystem = new ArrayList<>();

    // POST endpoint to add a Medicine to the pharmacy system
    @PostMapping
    public boolean addMedicine(@RequestBody Medicine medicine) {
        // You can add validation logic here if needed
        return pharmacySystem.add(medicine);
    }

    // PUT endpoint to update a Medicine by medicineId
    @PutMapping("/{medicineId}")
    public Medicine updateMedicine(@PathVariable int medicineId, @RequestBody Medicine updatedMedicine) {
        for (Medicine medicine : pharmacySystem) {
            if (medicine.getMedicineId() == medicineId) {
                // Update the existing medicine with the new details
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