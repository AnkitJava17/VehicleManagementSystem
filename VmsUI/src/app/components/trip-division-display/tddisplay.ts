interface Tddisplay {
    trip_ID: number;
    division_ID: number | null;
    source: string;
    destination: string;
    startDate: Date;
    endDate: Date;
    totalDistance: number;
    startTime: string;
    truck_ID: number;
    truck_model: string;
    truck_brand: string;
    truck_year: Date;
    available: boolean | null;
    truck_image: string;
    truck_source: string;
    truck_destination: string;
    truck_distance: number;
    trip_status: boolean;
  }
  