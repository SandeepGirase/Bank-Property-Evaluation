import { Routes } from '@angular/router';
import { HomeComponent } from './components/home.component';
import { PropertyListComponent } from './components/property-list.component';
import { PropertyDetailsComponent } from './components/property-details.component';
import { EvaluationFormComponent } from './components/evaluation-form.component';
import { AboutComponent } from './components/about.component';
import { ContactComponent } from './components/contact.component';
import { AdminDashboardComponent } from './components/admin-dashboard.component';

export const routes: Routes = [
	{ path: '', component: HomeComponent },
	{ path: 'properties', component: PropertyListComponent },
	{ path: 'properties/:id', component: PropertyDetailsComponent },
	{ path: 'evaluate', component: EvaluationFormComponent },
	{ path: 'about', component: AboutComponent },
	{ path: 'contact', component: ContactComponent },
	{ path: 'admin', component: AdminDashboardComponent },
	{ path: '**', redirectTo: '' }
];
