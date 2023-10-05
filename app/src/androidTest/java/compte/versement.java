package compte;

import java.util.Date;

public class versement extends operation {
    public versement(Date date, double mt) {
        super(date, "versement", mt);
    }
}