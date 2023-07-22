package det.ey.AdopterService.dto;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class BookingInfoDto {

    private int id;
    private String customerName;
    private String customerEmail;
}
