package com.company.object.ch1;

import java.util.LinkedList;
import java.util.List;

public class TicketOffice {

  private Long amount;
  private List<Ticket> tickets = new LinkedList<>();

  public void sellToTicketTo(Audience audience) {
    plusAmount(audience.buy(getTicket()));
  }

  public Ticket getTicket() {
    return tickets.remove(0);
  }

  private void plusAmount(Long amount) {
    this.amount += amount;
  }

}
