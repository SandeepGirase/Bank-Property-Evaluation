import { Component } from '@angular/core';
import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-admin-dashboard',
  standalone: true,
  imports: [CommonModule],
  template: `
    <section>
      <h2>Admin Dashboard</h2>
      <p>Admin-only views and controls (placeholder).</p>
    </section>
  `
})
export class AdminDashboardComponent {}
