import { Component } from '@angular/core';
import { CommonModule } from '@angular/common';
import { ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-property-details',
  standalone: true,
  imports: [CommonModule],
  template: `
    <section>
      <h2>Property Details</h2>
      <p *ngIf="id">Showing details for property id: {{id}}</p>
      <p *ngIf="!id">No property id provided.</p>
      <p>This is placeholder detail content — replace with real data/service call.</p>
    </section>
  `
})
export class PropertyDetailsComponent {
  id: string | null;
  constructor(private route: ActivatedRoute) {
    this.id = this.route.snapshot.paramMap.get('id');
  }
}
