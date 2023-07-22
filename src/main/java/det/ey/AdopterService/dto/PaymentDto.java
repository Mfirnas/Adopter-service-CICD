package det.ey.AdopterService.dto;

import lombok.Data;

@Data
public class PaymentDto {
    private  String Bank;
    private  long amount;
    private  String cardType;
}
