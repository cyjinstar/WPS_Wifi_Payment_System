package com.example.jckappwps;

import java.util.Vector;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class AccessPointAdapter {//need to change some methods
        private Vector<AccessPoint> accessPoints;
        private Context context;
        AccessPointAdapter(Vector<AccessPoint> accessPoints, Context context) {
            this.accessPoints = accessPoints;
            this.context = context;
        }

        @NonNull
        @Override
        //onCreateViewHolder  onBindViewHolder    ItemAccesspointBinding
        //getItemCount  cardView    ~~TextView << these should fixed.
        public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            RecyclerView.ViewHolder holder;
            ItemAccesspointBinding binding = ItemAccesspointBinding.inflate(LayoutInflater.from(context), parent, false);
            holder = new AccessPointHolder(binding);
            return holder;

        }


        @Override
        public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
            AccessPointHolder accessPointHolder = (AccessPointHolder)holder;
            final ItemAccesspointBinding binding = accessPointHolder.binding;
            binding.cardView.setRadius(20.0f);
            String ssid = "SSID : " + accessPoints.get(position).getSsid();
            String bSsid = "BSSID : " + accessPoints.get(position).getBssid();
            String rssi = "RSSI : " + accessPoints.get(position).getRssi();

            binding.ssidTextView.setText(ssid);
            binding.bssidTextView.setText(bSsid);
            binding.rssiLevelTextView.setText(rssi);
        }

        @Override
        public int getItemCount() {
            return accessPoints.size();
        }

        private class AccessPointHolder extends RecyclerView.ViewHolder {
            ItemAccesspointBinding binding;
            AccessPointHolder(ItemAccesspointBinding binding) {
                super(binding.getRoot());
                this.binding = binding;
            }
        }
}
